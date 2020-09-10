package backjun.dynamic;

import java.util.Scanner;

public class q11066 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();

            int[] files = new int[size + 1];
            int[] sum = new int[size + 1];
            int[][] dp = new int[size + 1][size + 1];

            for (int j = 1; j < files.length; j++) {
                files[j] = scanner.nextInt();
                sum[j] = sum[j - 1] + files[j];
            }

            for (int d = 1; d < size; d++) {
                for (int tx = 1; tx + d <= size; tx++) {
                    int ty = tx + d;
                    dp[tx][ty] = Integer.MAX_VALUE;

                    for (int mid = tx; mid < ty; mid++) {
                        dp[tx][ty] = Math.min(dp[tx][ty], dp[tx][mid] + dp[mid + 1][ty] + sum[ty] - sum[tx - 1]);
                    }
                }
            }

            System.out.println(dp[1][size]);
        }
    }
}
