package algorithm;

import java.util.Scanner;

public class MatrixExponentiation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int[][] result = calculateMatrixPower(arr, n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        //矩阵相乘，前一个矩阵的行和后一个矩阵的列必然相等
        int m = a.length;
        int n = a[0].length;
        int p = b[0].length;
        int[][] result = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] calculateMatrixPower(int[][] matrix, int power) {
        int[][] result = new int[matrix.length][matrix.length];
        // Initialize result matrix as identity matrix
        for (int i = 0; i < matrix.length; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if (power % 2 == 1) {
                result = multiplyMatrices(result, matrix);
            }
            matrix = multiplyMatrices(matrix, matrix);
            power /= 2;
        }

        return result;
    }
}