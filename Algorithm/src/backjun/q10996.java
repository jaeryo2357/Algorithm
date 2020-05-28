package backjun;

import java.util.Scanner;

public class q10996 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 1) {
            System.out.print("*");
            return;
        }

        boolean even = true;
        for (int t = 0 ;t < 2 * n; t++) {
            for (int num = 0; num < n; num++) {
                int x = even ? 0 : 1;
                if (num % 2 == x ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            even = !even;
            System.out.println();
        }

    }
}
