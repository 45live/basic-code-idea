package myfinalTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Dongjiaxin
 * {@code @create} //
 * {@code @description}
 */

public class StudentSystemLogin {
    private String userName;
    private String password;
    private String idcard;
    private String telephone;

    public StudentSystemLogin() {
    }

    public StudentSystemLogin(String userName, String password, String idcard, String telephone) {
        this.userName = userName;
        this.password = password;
        this.idcard = idcard;
        this.telephone = telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public static void readUserInfo(String path, ArrayList<StudentSystemLogin> list) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            StudentSystemLogin s = new StudentSystemLogin();
            String[] userInfo = line.replaceAll(",", " ").split("\\s+");
            s.setUserName(userInfo[0]);
            s.setPassword(userInfo[1]);
            s.setIdcard(userInfo[2]);
            s.setTelephone(userInfo[3]);
            list.add(s);
        }
    }

    public static void register(ArrayList<StudentSystemLogin> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.next();
        if (findUserName(list, userName) >= 0) {
            System.out.println("用户名已存在！");
        } else {
            StudentSystemLogin s = new StudentSystemLogin();
            while (!registerUserName(userName)) {
                System.out.println("用户名格式错误！请重新输入：");
                userName = sc.next();
            }
            s.setUserName(userName);
            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("请再次输入密码：");
            String rewrite = sc.next();
            while (!registerPassword(password, rewrite)) {
                System.out.println("两次密码不一致！");
                System.out.println("请输入密码：");
                password = sc.next();
                System.out.println("请再次输入密码：");
                rewrite = sc.next();
            }
            s.setPassword(password);
            System.out.println("请输入电话号码：");
            String telephone = sc.next();
            while (!registerTelephone(telephone)) {
                System.out.println("电话号码不符合规范！");
                System.out.println("请重新输入电话号码：");
                telephone = sc.next();
            }
            s.setTelephone(telephone);
            System.out.println("请输入身份证号：");
            String idcard = sc.next();
            while (!registerIdcard(idcard)) {
                System.out.println("身份证格式错误！");
                System.out.println("请重新输入身份证号：");
                idcard = sc.next();
            }
            s.setIdcard(idcard);
            System.out.println("注册成功！");
            list.add(s);
        }
    }

    public static boolean registerUserName(String userName) {
        if (userName.length() >= 3 && userName.length() <= 15) {
            for (int i = 0; i < userName.length(); i++) {
                if (!Character.isLetter(userName.charAt(i)) && !Character.isDigit(userName.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean registerPassword(String password, String rewrite) {
        return rewrite.equals(password);
    }

    public static boolean registerIdcard(String idcard) {
        if (idcard.length() == 18 && idcard.charAt(0) != '0') {
            for (int i = 0; i < idcard.length() - 1; i++) {
                if (!Character.isDigit(idcard.charAt(i))) {
                    return false;
                }
            }
            char lastCh = idcard.charAt(idcard.length() - 1);
            return Character.isDigit(lastCh) || lastCh == 'X' || lastCh == 'x';
        }
        return false;
    }

    public static boolean registerTelephone(String telephone) {
        return telephone.length() == 11 && telephone.charAt(0) != '0' && isNumeric(telephone);
    }

    public static boolean isNumeric(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int findUserName(ArrayList<StudentSystemLogin> list, String userName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    public static String Verification() {
        Random r = new Random();
        int indexNum = r.nextInt(5);
        char[] code = new char[5];
        int num = r.nextInt(10);
        code[indexNum] = (char) (num + 48);
        char[] character = new char[52];
        for (int i = 0; i < character.length; i++) {
            if (i < 26) {
                character[i] = (char) (97 + i);
            } else {
                character[i] = (char) (65 + i - 26);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < code.length; j++) {
                if (code[j] == '\u0000') {
                    code[j] = character[r.nextInt(character.length)];
                }
            }
        }
        return String.valueOf(code);
    }

    public static void login(ArrayList<StudentSystemLogin> list) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.next();
        int index = StudentSystemLogin.findUserName(list, userName);
        if (index >= 0) {
            String randomCode = Verification();
            System.out.println(randomCode);
            String code = "";
            while (!code.equals(randomCode)) {
                System.out.println("请输入验证码：");
                code = sc.next();
            }
            System.out.println("请输入密码：");
            String password = sc.next();
            for (int i = 0; i < 3; i++) {
                if (list.get(index).getPassword().equals(password)) {
                    if (list.get(index).getUserName().equals(userName)) {
                        System.out.println("登录成功！");
                        StudentSystemTest.main(new String[]{"0"});
                        return;
                    }
                }
                System.out.println("用户名或者密码错误，请重新输入：");
                System.out.println("请输入您的用户名：");
                userName = sc.next();
                System.out.println("请输入密码：");
                password = sc.next();
            }
            System.out.println("您的账户已锁定，请下次再试。");
        } else {
            System.out.println("用户名未注册，请先注册：");
        }
    }

    public static void forgetPassword(ArrayList<StudentSystemLogin> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.next();
        int index = findUserName(list, userName);
        if (index >= 0) {
            System.out.println("请输入您的手机号码：");
            String telephone = sc.next();
            System.out.println("请输入您的身份证号：");
            String idcard = sc.next();
            if (list.get(index).getTelephone().equals(telephone) && list.get(index).getIdcard().equals(idcard)) {
                System.out.println("请输入密码:");
                String password = sc.next();
                StudentSystemLogin s = list.get(index);
                s.setPassword(password);
                System.out.println("密码修改成功！");
            } else {
                System.out.println("账户信息不匹配，修改失败！");
            }
        } else {
            System.out.println("您的用户名未注册，请先注册：");
        }
    }
}
