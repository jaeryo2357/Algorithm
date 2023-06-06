package backjun.greedy;

import java.util.Scanner;

public class q4796 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = 1;
        while (true) {
            int l = scanner.nextInt();
            int p = scanner.nextInt();
            int n = scanner.nextInt();

            if (l == 0 && p == 0 && n == 0) {
                break;
            }

            int answer = 0;

            answer += (n / p) * l;
            answer += n % p > l ? l : n % p;

            System.out.printf("Case %d: %d\n", t++, answer);
        }
    }
}
