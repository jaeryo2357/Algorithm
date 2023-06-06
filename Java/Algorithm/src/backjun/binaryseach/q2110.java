package backjun.binaryseach;

import java.util.Arrays;
import java.util.Scanner;

public class q2110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();

        long[] x = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextLong();
            max = Math.max(max, x[i]);
        }

        Arrays.sort(x);

        long min = 0;
        long answer = 0;
        while (min <= max) {
            long middle = (min + max) / 2;

            long count = 1;
            long lastPosition = x[0];
            for (int i = 1; i < n; i++) {
                long l = x[i] - lastPosition;
                if (l >= middle) {
                    count++;
                    lastPosition = x[i];
                }
            }

            if (count >= c) {
                answer = Math.max(answer, middle);
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }

        System.out.println(answer);
    }
}
