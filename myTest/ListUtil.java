package myTest;

import java.util.ArrayList;

public class ListUtil {
    /*
    定义一个工具类，类中定义一个方法addAll, 用来添加多个集合的元素
    */
    private ListUtil() {
    }

    /*
    参数一：集合
    参数二~最后：要添加的元素
     */

    public static <E> void addAll(ArrayList<E> list, E e1, E e2, E e3, E e4) {
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
    }

    public static <E> void addAll2(ArrayList<E> list, E... e) {
        for (E element : e) {
            list.add(element);
        }
    }

    public static void show() {
        System.out.println("尼古拉斯.宇宙第一.阿强");
    }
}
