package algorithm;

import java.util.Scanner;

public class dateTest {
    public static void main(String[] args) {
        //定义一个max表示共有多少个皇后
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        //定义一个数组array,保存皇后放置位置的结果，比如arr={0,4,7,5,2,6,1,3}
        //arr[0]=0表示第一个皇后放在第一行的第一列
        int[] arr = new int[max];
    }

    //编写一个方法，放置第n个皇后
    private void check(int n, int[] arr, int max) {
        if (n == max) {
            //表示皇后放置完毕了

        }
    }

    //查看当我们放置第n个皇后时，检测该皇后是否与前面已经放置好的皇后冲突
    private boolean judge(int[] arr, int n) {
        //将n前面的几个皇后进行检测
        for (int i = 0; i < n; i++) {
            //说明：
            //1. arr[i]==arr[n]表示判断第n个皇后是否和前面的皇后在同一列
            //2. Math.abs(n-i)==Math.abs(arr[n]-arr[i])表示判断第n个皇后是否和第i个皇后是否在同一斜线
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}