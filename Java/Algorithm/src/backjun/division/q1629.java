package backjun.division;

import java.util.Scanner;

public class q1629 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        System.out.println(division(a, b, c));
    }

    public static long division(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        } else if (b % 2 == 0) {
            long answer = division(a, b / 2, c);

            return (answer * answer) % c;
        } else {
            long answer = division(a, b / 2, c);

            return ((answer * answer % c) * a) % c;
        }
    }
}
