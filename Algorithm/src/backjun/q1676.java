package backjun;

import java.util.Scanner;

public class q1676 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int twoCount = 0;
        int fiveCount = 0;

        for (int i = 1; i <= n; i++) {

            int number = i;
            while (number != 0 && number % 2 == 0) {
                number = number / 2;
                twoCount += 1;
            }

            while (number >= 5 && number % 5 == 0) {
                number = number / 5;
                fiveCount += 1;
            }
        }

        System.out.println(Math.min(twoCount, fiveCount));
    }
}
