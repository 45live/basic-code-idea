package myTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class rollHighRate {
    public static void main(String[] args) {
        /*
        班级里有n个学生，学生属性：姓名，年龄，性别
        实现随机点名器：
        被点到的学生不会再被点到，但是如果班级中的所有学生都被点完了，
        需要重新开启第二轮点名
         */

        //这种写法效率更高，之前的随机数写法，生成的随机数不确定，有可能很多轮
        //都点到同样的，效率低

        //1. 定义集合
        ArrayList<String> list1 = new ArrayList<>();
        //2. 添加数据
        Collections.addAll(list1, "范闲", "范建", "范统", "杜子腾", "杜琦燕", "宋合泛", "候龙腾", "朱益群", "朱穆朗姆峰", "袁明媛");
        //创建一个临时集合，用来存放已经被点到的学生的名字
        ArrayList<String> list2 = new ArrayList<>();
        //外循环，表示轮数
        for (int i = 0; i < 10; i++) {
            System.out.println("=========================第" + i + "轮循环开始了======================");
            //3. 获取集合的长度，保证所有元素都被抽取，因为集合长度会变
            int size = list1.size();
            Random r = new Random();
            for (int j = 0; j < size; j++) {
                int index = r.nextInt(list1.size());
                String name = list1.remove(index);
                list2.add(name);
                System.out.println(name);
            }
            //此时表示一轮点名已经结束
            //list1已经空了，list2中存储了10个学生的名字
            list1.addAll(list2);
            list2.clear();
        }

    }
}
