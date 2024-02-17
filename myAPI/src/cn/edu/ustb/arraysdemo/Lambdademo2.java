package cn.edu.ustb.arraysdemo;

import java.util.Arrays;

public class Lambdademo2 {
    public static void main(String[] args) {
        /*
        Lambda表达式的省略规则：
            1.参数类型可以省略不写
            2.如果只有一个参数，参数类型可以省略，同时()也可以省略
            3.如果Lambda表达式的方法体只有 一行 ，大括号，分号，return可以省略不写，但是需要同时省略
         */

        Integer[] arr = {2, 3, 1, 5, 6, 7, 8, 4, 9, 0};

        //Lambda表达式完整格式
        /*Arrays.sort(arr, (Integer o1, Integer o2) -> {
                    return o1 - o2;
                }
        );*/

        //Lambda表达式的省略写法
        //重写方法，要求参数类型完全一样
        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        System.out.println(Arrays.toString(arr));
    }
}
