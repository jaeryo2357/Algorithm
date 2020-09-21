package backjun.binaryseach;

import java.util.Scanner;

public class q1300 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long k = scanner.nextLong();


        long start = 1;
        long end = k;
        long answer = -1;

        while (start <= end) {
            long middle = (start + end) / 2;
            long count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(middle / i, n);
            }

            if (count < k) {
                start = middle + 1;
            } else {
                answer = middle;
                end = middle - 1;
            }
        }

        System.out.println(answer);
    }
}
