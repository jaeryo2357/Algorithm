package backjun.dynamic;

import java.util.Scanner;

public class q11055 {

    private static int dp[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        dp = new int[n];

        for (int i = 0; i < n; i++ ) {
            dp[i] = -1;
        }

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(dfs(0, 0, a));
    }

    public static int dfs(int position, int previousValue, int[] a) {
      if (position == a.length) {
          return 0;
      } else if (dp[position] != -1) {
          return dp[position];
      } else {

          int maxLength = -1;
          for (int i = position; i < a.length; i++) {
              if (previousValue < a[i]) {
                  maxLength = Math.max(maxLength, dfs(i + 1, a[i], a) + a[i]);
              }
          }

          dp[position] = maxLength;
          return dp[position] == -1 ? 0 : dp[position];
      }
    }
}
