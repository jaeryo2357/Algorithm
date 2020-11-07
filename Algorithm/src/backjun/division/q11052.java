package backjun.division;

import java.util.Scanner;

public class q11052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n + 1];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int newValue = j + i + 1;
                if (newValue <= n) {
                    dp[newValue] = Math.max(dp[newValue], dp[j] + p[i]);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
