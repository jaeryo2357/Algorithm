package backjun;

import java.util.Scanner;

public class q11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int answer = 0;

        int[] coin = new int[n];
        for (int index = 0; index < n; index++) {
            coin[index] = scanner.nextInt();
        }

        for (int index = n - 1; index >= 0; index--) {
            int count = k / coin[index];
            answer += count;
            k %= coin[index];

            if (k == 0) break;
        }

        System.out.println(answer);
    }
}
