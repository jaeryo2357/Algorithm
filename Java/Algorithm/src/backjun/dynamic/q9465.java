package backjun.dynamic;

import java.util.Scanner;

public class q9465 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        int[][] board;
        int[][] dp;

        for (int t = 0; t < testCase; t++) {
            int n = scanner.nextInt();

            board = new int[2][n];

            for(int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }

            dp = new int[n + 1][3];
            //0은 왼쪽 스티커에서 아무것도 안 떈경우
            //1은 왼쪽 스티커에서 첫번째 스티커를 땐경우
            //2는 왼쪽 스티커에서 두번째 스티커를 땐경우
            for (int i = 0; i < n; i++) {

                dp[i + 1][0] = Math.max(dp[i + 1][0], Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])));
                dp[i + 1][1] = Math.max(dp[i + 1][1], Math.max(dp[i][0], dp[i][2]) + board[0][i]);
                dp[i + 1][2] = Math.max(dp[i + 1][2], Math.max(dp[i][0], dp[i][1]) + board[1][i]);
            }

            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        }
    }
}
