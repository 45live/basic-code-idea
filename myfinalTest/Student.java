package myfinalTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Dongjiaxin
 * {@code @create} //
 * {@code @description}
 */

public class Student implements Comparable {
    private String id;
    private String name;
    private int age;
    private String address;
    private String[] grades;
    public static ArrayList<Student> list = new ArrayList<>();

    public Student() {
    }


    public Student(String id, String name, int age, String address, String[] grades, ArrayList<Student> list) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.grades = grades;
        Student.list = list;
    }


    /**
     * 获取
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     *
     * @return grades
     */
    public String[] getGrades() {
        return grades;
    }

    /**
     * 设置
     *
     * @param grades
     */
    public void setGrades(String[] grades) {
        this.grades = grades;
    }


    public static void printMainOrder() {
        System.out.println("---------------欢迎来到学生管理系统-----------------");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查询学生");
        System.out.println("5.退出");
        System.out.println("请输入您的选择：");
    }

    public static void addStudent(String path) throws IOException {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        System.out.println("请输入要添加的学生的ID：");
        String id = sc.next();
        sc.nextLine();
        if (findId(Student.list, id) < 0) {
            System.out.println("请输入学生的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入学生的年龄：");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("请输入学生的家庭地址：");
            String address = sc.nextLine();
            System.out.println("请输入学生的成绩：");
            String[] tableName = Student.readTableName(path);
            String[] grades = new String[tableName.length - 4];
            int index = 0;
            for (int i = 4; i < tableName.length; i++) {
                String grade = sc.nextLine();
                grades[index++] = grade;
            }
            s.setId(id);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);
            s.setGrades(grades);
            list.add(s);
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！当前学生ID已存在！");
        }
    }


    public static void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要删除的学生id：");
        String id = sc.nextLine();
        int index = findId(list, id);
        if (index >= 0) {
            list.remove(index);
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败，当前ID不存在！");
        }
    }

    public static void updateStudent(String path) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要修改的学生id：");
        String id = sc.nextLine();
        int index = findId(list, id);
        if (index >= 0) {
            Student s = list.get(index);
            System.out.println("请继续录入其他信息：");
            System.out.println("请输入学生的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入学生的年龄：");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("请输入学生的家庭地址：");
            String address = sc.nextLine();
            System.out.println("请输入学生的成绩：");
            String[] table = readTableName(path);
            String[] grades = new String[table.length - 4];
            int count = 0;
            for (int i = 4; i < table.length; i++) {
                String grade = sc.nextLine();
                grades[count++] = grade;
            }
            s.setId(id);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);
            s.setGrades(grades);
            list.set(index, s);
            System.out.println("信息修改成功！");
        } else {
            System.out.println("信息修改失败，当前ID不存在！");
        }
    }

    public static void queryStudent(String path) throws IOException {
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再进行访问：");
        } else {
            Collections.sort(list);
            System.out.println(list.size());
            System.out.println("id\t姓名\t年龄\t家庭住址\t分数");
            for (Student student : list) {
                System.out.println(student.getId() + "\t" + student.getName() + "\t" +
                        student.getAge() + "\t" + student.getAddress() + "\t" + Arrays.toString(student.grades));
            }
            showAvg(path);
            showSumGrade(list);
        }
    }


    public static void readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            Student stu = new Student();
            String[] newData = line.replaceAll(",", " ").split("\\s+");
            String[] grades = new String[newData.length - 4];
            int count = 0;
            for (int i = 4; i < newData.length; i++) {
                grades[count++] = newData[i];
            }
            stu.setId(newData[0]);
            stu.setName(newData[1]);
            stu.setAge(Integer.parseInt(newData[2]));
            stu.setAddress(newData[3]);
            stu.setGrades(grades);
            list.add(stu);
        }
        br.close();
    }

    public static String[] readTableName(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        return s.replaceAll(",", " ").split("\\s+");
    }

    public static int findId(ArrayList<Student> list, String id) {
        if (list == null) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student != null && id != null && id.equals(student.getId())) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int compareTo(Object obj) {
        if (this == obj) {
            return 0;
        } else {
            int sum1 = 0;
            int sum2 = 0;
            for (String grade : this.grades) {
                sum1 += Integer.parseInt(grade);
            }
            Student stu = (Student) obj;
            for (int i = 0; i < stu.grades.length; i++) {
                sum1 += Integer.parseInt(grades[i]);
            }
            return Integer.compare(sum1, sum2);
        }
    }

    public static double[] calculatorAvg(ArrayList<Student> list) {
        int sum = 0;
        double[] avg = new double[list.get(0).grades.length];
        int count = 0;
        for (int i = 0; i < list.get(0).grades.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                sum += Integer.parseInt(list.get(j).grades[i]);
            }
            avg[count++] = (double) sum / list.size();
            sum = 0;
        }
        return avg;
    }

    public static void showAvg(String path) throws IOException {
        Scanner sc = new Scanner(System.in);
        double[] avg = calculatorAvg(list);
        String[] tableName = readTableName(path);
        String choose;
        while (true) {
            System.out.println("请输入想要查询的科目的平均成绩，或者按exit退出：（输入科目名）");
            for (int i = 4; i < tableName.length; i++) {
                System.out.println((i - 3) + "." + tableName[i]);
            }
            choose = sc.nextLine();
            if (!choose.equalsIgnoreCase("exit")) {
                int index = -1;
                for (int i = 4; i < tableName.length; i++) {
                    if (choose.equals(tableName[i])) {
                        index = i;
                        break;
                    }
                }
                if (index >= 0) {
                    System.out.println("查询成功！");
                    System.out.println(avg[index - 4]);
                } else {
                    System.out.println("查询失败！没有该门科目，请重新选择，或者按exit退出：");
                }
            } else {
                break;
            }
        }
    }

    public static void showSumGrade(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        int[] sum = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).grades.length; j++) {
                sum[i] += Integer.parseInt(list.get(i).grades[j]);
            }
        }
        String choose;
        while (true) {
            System.out.println("请输入想要查询的某人的总成绩，或者按exit退出：（输入人名）");
            choose = sc.nextLine();
            if (!choose.equalsIgnoreCase("exit")) {
                int index = -1;
                for (int i = 0; i < list.size(); i++) {
                    if (choose.equals(list.get(i).name)) {
                        index = i;
                        break;
                    }
                }
                if (index >= 0) {
                    System.out.println("查询成功！");
                    System.out.println(sum[index]);
                } else {
                    System.out.println("查询失败！没有该学生，请重新选择，或者按exit退出：");
                }
            } else {
                break;
            }
        }
    }
}
