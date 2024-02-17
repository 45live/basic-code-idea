package cn.edu.ustb.arraysdemo;

import java.util.Arrays;

public class Arraysdemo1 {
    public static void main(String[] args) {
        //toString 将数组变成字符串
        System.out.println("--------------------toString----------------------");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arr));

        //binarySearch 二分法查找元素
        //细节1：二分查找的前提：数组中的元素必须是数字，数组中的元素必须是升序排列的
        //细节2：如果查找的元素是存在的，则会返回真实的索引，如果查找的元素是不存在的，返回的是-插入点-1
        //插入点指的是如果这个数值在数组中存在，那么会在哪个位置
        //-10 - 1
        //-1的原因是，如果查找数字0，此时数字0索引为0，返回-插入点，也就是0，会造成误会，所以-1
        System.out.println("--------------------binarySearch-------------------");
        System.out.println(Arrays.binarySearch(arr, 10));
        System.out.println(Arrays.binarySearch(arr, 2));
        System.out.println(Arrays.binarySearch(arr, 20));

        //copyOf 拷贝数组
        //参数一：老数组
        //参数二：新数组
        //方法的底层会根据第二个参数来创建新的数组
        //如果新数组的长度小于老数组的长度，那么就会部分拷贝
        //如果新数组的长度等于老数组的长度，那么会完全拷贝
        //如果新数组的长度大于老数组的长度，会补上默认初始化值
        System.out.println("---------------------copyOf--------------------");
        int[] newArr1 = Arrays.copyOf(arr, 20);
        System.out.println(Arrays.toString(newArr1));

        //copyOfRange 拷贝数组（指定范围）
        //细节：包头不包尾，包左不包右
        System.out.println("---------------------copyOfRange-------------------");
        int[] newArr2 = Arrays.copyOfRange(arr, 0, 9);
        System.out.println(Arrays.toString(newArr2));//[1, 2, 3, 4, 5, 6, 7, 8, 9]

        //fill 填充数组
        System.out.println("--------------------fill--------------------");
        Arrays.fill(arr, 100);
        System.out.println(Arrays.toString(arr));

        //sort 排序，默认情况下，给基本数据类型进行升序排列
        System.out.println("--------------------sort--------------------");
        int[] arr2 = {10, 2, 3, 5, 6, 1, 7, 8, 4, 9};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
