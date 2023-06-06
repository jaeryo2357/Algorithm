package backjun.division;

import java.util.Scanner;

public class q11401 {
    public static long p = 1000000007L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();

        long answer = ((fac(n) % p) * ((division(fac(k), p - 2) % p) * (division(fac(n - k), p - 2) % p) % p) % p);
        System.out.println(answer);
    }

    public static long division(long n, long k) {
        if (k == 1) {
            return n;
        } else {
            long temp = division(n, k / 2);
            if (k % 2 == 1) {
                return ((temp * temp % p) * n) % p;
            } else {
                return (temp * temp) % p;
            }
        }
    }

    public static long fac(long n) {
        if (n <= 1) return 1;
        return (n * fac(n - 1)) % p;
    }
}
