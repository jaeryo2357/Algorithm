package backjun.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class q16500 {
    private static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        dp = new int[s.length()];

        int n = scanner.nextInt();

        scanner.nextLine();

        String[] a = new String[n];

        Arrays.fill(dp, -1);

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextLine();
        }


        System.out.println(dfs(0, s, a));
    }

    public static int dfs(int position, String s, String[] a) {

        if (position >= s.length()) {
            return 1;
        } else if (dp[position] != -1) {
            return dp[position];
        } else {

            int answer = 0;

            for (int i = 0; i < a.length; i++) {
                String target = a[i];
                String temp = s.substring(position, Math.min(position + target.length(), s.length()));

                if (temp.equals(target)) {
                    answer = Math.max(answer, dfs(position + target.length(), s, a));
                    if (answer == 1) {
                        break;
                    }
                }
            }

            dp[position] = answer;
            return dp[position];
        }
    }
}
