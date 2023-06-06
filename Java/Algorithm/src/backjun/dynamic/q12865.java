package backjun.dynamic;

import java.util.Scanner;

public class q12865 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int maxWeight = scanner.nextInt();

        int[][] objects = new int[n + 1][2];
        int[][] dp = new int[n + 1][maxWeight + 1];
        int answer = 0;

        for (int index = 1; index <= n; index++) {
            objects[index][0] = scanner.nextInt(); //무게
            objects[index][1] = scanner.nextInt(); //가치
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - objects[i][0] >= 0) {
                    int value = dp[i - 1][j - objects[i][0]] + objects[i][1];
                    dp[i][j] = Math.max(value, dp[i][j]);

                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
