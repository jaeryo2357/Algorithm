package backjun;

import java.util.Scanner;

public class q11050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(factorial(n) / (factorial(k) * factorial(n - k)));
    }

    public static int factorial(int n) {
        if (n == 0) return 1;

        return n * factorial(n - 1);
    }
}
