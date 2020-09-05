package backjun.dynamic;

import java.util.Scanner;

public class q2293 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[k + 1];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (arr[i] <= j && j - arr[i] >= 0) {
                    dp[j] += dp[j - arr[i]];
                }
            }
        }

        System.out.println(dp[k]);
    }
}
