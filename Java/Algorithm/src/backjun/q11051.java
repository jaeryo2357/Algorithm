package backjun;

import java.util.Scanner;

public class q11051 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] c = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j <=  i; j++) {
                if ( j == 0 || i == j) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % 10007;
                }
            }
        }

        System.out.println(c[n][k]);
    }
}
