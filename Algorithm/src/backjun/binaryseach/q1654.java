package backjun.binaryseach;

import java.util.Scanner;

public class q1654 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long[] len = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            len[i] = scanner.nextLong();
            if (max < len[i]) {
                max = len[i];
            }
        }

        long start = 1;
        long end = max;

        long middle = (1 + max) / 2;

        long answer = 0;
        while(start <= end) {

            int count = 0;
            for (int i = 0; i < n; i++) {
                count += len[i] / middle;
            }

            if (count >= k) {
                answer = Math.max(middle, answer);
                start = middle + 1;

            } else {
                end = middle - 1;
            }
            middle = (start + end) / 2;
        }

        System.out.println(answer);
    }
}
