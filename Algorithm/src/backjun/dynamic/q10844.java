package backjun.dynamic;

import java.util.Scanner;

public class q10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[][] dp = new long[n + 1][10];
        long result = 0;

        for (int number =  1; number < 10; number++) {
            result += findStair(dp, n, number);
        }

        System.out.println(result % 1000000000);
    }

    public static long findStair(long[][] dp, int length, int startNumber) {
        if (length == 1) {
            return 1;
        } else if (dp[length][startNumber] != 0) {
            return dp[length][startNumber];
        } else {
            long totalStair = 0;

            for (int number = 0; number < 10; number++) {
                if (Math.abs(startNumber - number) == 1) {
                    totalStair += findStair(dp, length - 1, number);
                }
            }
            totalStair %= 1000000000;
            dp[length][startNumber] = totalStair;
            return totalStair;
        }
    }
}
