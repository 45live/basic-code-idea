package myfinalTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dongjiaxin
 * {@code @create} //
 * {@code @description}
 */

public class newSystemTest {
    private static final String LOGIN = "1";
    private static final String REGISTER = "2";
    private static final String FIND_PASSWORD = "3";

    public static void main(String[] args) throws IOException {
        ArrayList<StudentSystemLogin> list = new ArrayList<>();
        String path = "D:\\code\\basic-code-idea\\practice-code\\src\\myfinalTest\\UserData.txt";
        StudentSystemLogin.readUserInfo(path, list);
        while (true) {
            welcome();
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的选择：");
            String choose = sc.next();
            switch (choose) {
                case LOGIN -> StudentSystemLogin.login(list);
                case REGISTER -> StudentSystemLogin.register(list);
                case FIND_PASSWORD -> StudentSystemLogin.forgetPassword(list);
                default -> {
                    System.out.println("退出成功！");
                    System.exit(0);
                }
            }
        }
    }

    public static void welcome() {
        System.out.println("-----------------------欢迎来到学生管理系统-------------------------");
        System.out.println("请选择操作：");
        System.out.println("1:登录");
        System.out.println("2:注册");
        System.out.println("3:忘记密码");
    }
}
