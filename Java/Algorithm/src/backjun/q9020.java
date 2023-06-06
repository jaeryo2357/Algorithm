package backjun;

import java.util.Scanner;

public class q9020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t > 0) {

            int n = scanner.nextInt();
            boolean[] prime = new boolean[n + 1];

            for (int i = 2; i * i <= n; i++) {
                if (prime[i]) {
                    continue;
                }

                for (int j = i + i; j <= n; j += i) {
                    if (j % i == 0) {
                        prime[j] = true;
                    }
                }
            }

            for (int i = n / 2; i > 1; i++) {
                if (!prime[i]) { //소수 이면
                    int diff = n - i;
                    if (!prime[diff]) {
                        System.out.printf("%d %d\n",diff,i);
                        break;
                    }
                }
            }

            t--;
        }
    }
}
