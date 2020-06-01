package backjun;

import java.util.Scanner;

public class q2581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int result = 0;
        int min = 0;


        for (int num = m; num <= n; num++) {
            boolean isPrime = true;

            if (num == 1) continue;

            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                if (result == 0) {
                   min = num;
                }
                result += num;
            }
        }

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
            System.out.println(min);
        }
    }
}
