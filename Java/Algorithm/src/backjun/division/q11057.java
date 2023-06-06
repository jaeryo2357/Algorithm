package backjun.division;

import java.util.Scanner;

public class q11057 {
    private static long[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        dp = new long[n][10];

        System.out.println(dfs(0, 0, n));
    }

    public static long dfs(int start, int position, int end) {
        if (position == end) {
            return 1;
        } else if (dp[position][start] != 0) {
            return dp[position][start] % 10007;
        } else {
            long count = 0;

            for (int i = start; i < 10; i++) {
                count = (count + dfs(i, position + 1, end)) % 10007;
            }

            dp[position][start] = count;
            return dp[position][start];
        }
    }
}
