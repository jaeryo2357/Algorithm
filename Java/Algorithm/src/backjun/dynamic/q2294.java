package backjun.dynamic;


import java.util.Scanner;

public class q2294 {
    private static final int IMPOSSIBLE = 100001;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] coin = new int[n];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = scanner.nextInt();
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = IMPOSSIBLE;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
            for (int j = 0; j <= k; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);

                int jj = j + coin[i];
                if (jj <= k) {
                    dp[i][jj] = Math.min(dp[i][jj], dp[i][j] + 1);
                }
            }
        }


        //왜 n - 1일까? 배열이니까
        System.out.println(dp[n - 1][k] == IMPOSSIBLE ? -1 : dp[n - 1][k]);

    }
}
