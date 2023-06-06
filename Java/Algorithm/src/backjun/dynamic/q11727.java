package backjun.dynamic;

import java.util.Scanner;

public class q11727 {
    private static long[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        dp = new long[n + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(dfs(0));
    }

    public static long dfs(int position) {
        if (position >= dp.length - 1) {
            return position == dp.length - 1 ? 1 : 0;
        } else if (dp[position] != -1) {
            return dp[position];
        } else {
            long count = 0;

            count = (count + dfs(position + 1)) % 10007;

            count = (count + ((dfs(position + 2) * 2) % 10007 )) % 10007;

            dp[position] = count;
            return dp[position];
        }
    }
}
