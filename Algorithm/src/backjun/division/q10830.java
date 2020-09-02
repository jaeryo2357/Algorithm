package backjun.division;

import java.util.Scanner;

public class q10830 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long b = scanner.nextLong();

        long[][] arr = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (scanner.nextInt() % 1000);
            }
        }

        arr = division(arr, b);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static long[][] division(long[][] arr, long b) {
        if (b == 1) {
            return arr;
        } else {

            if (b % 2 == 0) {
                long[][] tempArr = division(arr, b / 2);
                return mult(tempArr, tempArr);
            } else {
                long[][] tempArr = division(arr, b / 2);
                tempArr = mult(tempArr, tempArr);
                return mult(tempArr, arr);
            }
        }
    }

    public static long[][] mult(long[][] arrA, long[][] arrB) {
        long[][] answer = new long[arrA[0].length][arrB.length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j <  answer[i].length; j++) {
                for (int k = 0; k <  answer[i].length; k++) {
                    answer[i][j] = (answer[i][j] + (arrA[i][k] * arrB[k][j]) % 1000) % 1000;
                }
            }
        }

        return answer;
    }
}
