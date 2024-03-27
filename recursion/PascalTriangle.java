package recursion;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int[][] arr = recurrence(n);
        int[][] arr = new int[n][n];
        for (int k = 0; k < n; k++) {
            arr[k][0] = 1;
            arr[k][k] = 1;
        }
        pascalTriangle(2, n, arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] recurrence(int n) {
        //递推解决杨辉三角，空间换时间
        //第一列全部是1，对角线全部是1
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        //1
        //1 1
        //1 2 1
        for (int i = 2; i < n; i++) {
            //从第二行第一列开始
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        return arr;
    }

    public static void pascalTriangle(int i, int n, int[][] arr) {
        if (i == n) {
            return;
        }
        //第一列全部是1，对角线全部是1
        //然后从第二行第一列开始递归
        //1
        //1 1
        //1 2 1
        for (int k = 1; k < i + 1; k++) {
            arr[i][k] = arr[i - 1][k] + arr[i - 1][k - 1];
        }
        pascalTriangle(i + 1, n, arr);
    }
}
