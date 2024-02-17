package cn.edu.ustb.arraysdemo;

import java.util.Arrays;

public class Arraysdemo2 {
    public static void main(String[] args) {
        /*
        初识lambda表达式

         */

        Integer[] arr = {2, 3, 1, 5, 6, 7, 8, 4, 9};

        Arrays.sort(arr, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });

        System.out.println(Arrays.toString(arr));
    }
}
