package backjun.dynamic;

import java.util.Scanner;

public class q2193 {
    private static long[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        dp = new long[n][2];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        System.out.println(dfs(0, 1));
    }

    public static long dfs(int position, int select) {
        if (position == dp.length - 1) {
            return 1;
        } else if (dp[position][select] != -1) {
            return dp[position][select];
        } else {
            long count = 0;

            if (select == 0) {
                count += dfs(position + 1, 1);
            }

            count += dfs(position + 1, 0);

            dp[position][select] = count;
            return dp[position][select];
        }
    }
}
