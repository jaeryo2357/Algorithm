package backjun.division;

import java.util.Scanner;

public class q2740 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int an = scanner.nextInt();
        int am = scanner.nextInt();

        int[][] arrA = new int[an][am];

        for (int i = 0; i < an; i++) {
            for (int j = 0; j < am; j++) {
                arrA[i][j] = scanner.nextInt();
            }
        }

        int bn = scanner.nextInt();
        int bm = scanner.nextInt();
        int[][] arrB = new int[bn][bm];

        for (int i = 0; i < bn; i++) {
            for (int j = 0; j < bm; j++) {
                arrB[i][j] = scanner.nextInt();
            }
        }

        int[][] answer = new int[an][bm];

        for (int i = 0; i < an; i++) {
            for (int j = 0; j < bm; j++) {
                for (int k = 0; k < am; k++) {
                    answer[i][j] += arrA[i][k] * arrB[k][j];
                }
            }
        }

        for (int i = 0; i < an; i++) {
            for (int j = 0; j < bm; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
