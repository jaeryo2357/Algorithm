package backjun.dynamic;

import java.util.Scanner;

public class q1699 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        final int IMPOSSIBLE = n  + 1;
        int[] dp = new int[n + 1];

        for (int i = 0; i < dp.length; i++) {
                dp[i] = IMPOSSIBLE;
        }

        dp[0] = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            for (int k = 0; k <= n; k++) {
                int value  = k + (int)Math.pow(i, 2);
                if (value <= n) {
                    dp[value] = Math.min(dp[value], dp[k] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
