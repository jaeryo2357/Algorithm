package backjun.dynamic;

import java.util.Scanner;

public class q1003 {
    private static int count = 0;
    private static int[] saveValue = new int[41];
    private static int[] saveCount = new int[41];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < saveValue.length; i++) {
            saveValue[i] = -1;
        }

        for (int test = 0; test < t; test++) {

            int n = scanner.nextInt();

            count = 0;
            int value = fibonacci(n);
            System.out.printf("%d %d\n", count, value);

        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            count++;
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (saveValue[n] != -1) {
            count += saveCount[n];
            return saveValue[n];
        } else {
            int fibonacci = fibonacci(n - 1) + fibonacci(n - 2);
            saveCount[n] += count;
            saveValue[n] = fibonacci;
            return fibonacci;
        }
    }
}
