package myTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class rollTest {
    public static void main(String[] args) {
        /*
        班级里有n个学生，学生属性：姓名，年龄，性别
        实现随机点名器：
        被点到的学生不会再被点到，但是如果班级中的所有学生都被点完了，
        需要重新开启第二轮点名
         */

        //1.定义集合
        ArrayList<String> list = new ArrayList<>();
        //2.添加数据
        Collections.addAll(list, "范闲", "范建", "范统", "杜子腾", "杜琦燕", "宋合泛", "候龙腾", "朱益群", "朱穆朗姆峰", "袁明媛");
        ArrayList<String> record = new ArrayList<>();

        //3.随机点名，不重复
        //也可以将当前随机到的数据进行remove, 这样的话下次随机到的就一定不是该元素了
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        String choose = sc.nextLine();
        while (!choose.equals("exit")) {
            int index = r.nextInt(list.size());
            while (record.contains(list.get(index))) {
                index = r.nextInt(list.size());
            }
            record.add(list.get(index));
            System.out.println(list.get(index));
            if (record.size() == list.size()) {
                record.clear();
            }
            choose = sc.nextLine();
        }
    }
}
