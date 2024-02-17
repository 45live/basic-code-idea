package myfinalTest;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Dongjiaxin
 * {@code @create} 2023/12/2
 * {@code @description}
 */

public class StudentSystemTest {
    private static final String ADD_STUDENT = "1";
    private static final String DELETE_STUDENT = "2";
    private static final String UPDATE_STUDENT = "3";
    private static final String QUERY_STUDENT = "4";

    public static void main(String[] args) throws IOException {
        String path = "E:\\code\\basic-code-idea\\practice-code\\src\\myFinalTest\\TestData.txt";
        Student.readFile(path);
        Scanner sc = new Scanner(System.in);
        while (true) {
            Student.printMainOrder();
            String choose = sc.nextLine();
            switch (choose) {
                case ADD_STUDENT -> Student.addStudent(path);
                case DELETE_STUDENT -> Student.deleteStudent();
                case UPDATE_STUDENT -> Student.updateStudent(path);
                case QUERY_STUDENT -> Student.queryStudent(path);
                default -> System.exit(0);
            }
        }
    }
}


