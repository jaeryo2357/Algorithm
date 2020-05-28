package backjun;

import java.util.Scanner;

public class q2523 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int t = 1; t < 2 * n; t++) {
            int time = t;
            if (t > n) {
                time = n - t % n;
            }
            for (int num = 0 ; num < time; num++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
