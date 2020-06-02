package backjun;

import java.util.Scanner;

public class q1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        for (int t = m; t <= n; t++) {
            if (isPrime(t)) {
                System.out.println(t);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int n = 2; n <= (int) Math.sqrt(number); n++) {
            if (number % n == 0) {
                return false;
            }
        }
        return true;
    }
}
