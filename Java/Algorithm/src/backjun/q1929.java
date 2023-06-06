package backjun;

import java.util.Scanner;

public class q1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        eratos(m, n);

//        for (int t = m; t <= n; t++) {
//            if (isPrime(t)) {
//                System.out.println(t);
//            }
//        }
    }

    public static void eratos(int start, int end) {
        boolean[] ranges = new boolean[end]; //기본값 false
        ranges[0] = true;

        for (int t = 2; t * t <= end; t++) {
            if (ranges[t - 1]) {
                continue;
            }

            for (int i = t + t; i <= end; i += t) {
                if (i % t == 0) {
                    ranges[i - 1] = true;
                }
            }
        }

        for (int t = start - 1; t < ranges.length; t++) {
            if (!ranges[t]) {
                System.out.println(t + 1);
            }
        }
    }

    //제곱근으로 소수를 구하는 방법
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
