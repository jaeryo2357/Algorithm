package backjun;

import java.util.Scanner;

public class q11022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t< T ; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.printf("Case #%d: %d + %d = %d\n", t + 1, a, b, a + b);
        }
    }
}
