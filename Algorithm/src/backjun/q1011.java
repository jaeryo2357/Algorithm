package backjun;

import java.util.Scanner;

public class q1011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int index = 0; index < t; index++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();

            long distance = y - x;

            long sqrt = (long) Math.sqrt(distance);

            if (sqrt * sqrt == distance) {
                System.out.println(sqrt * 2 - 1);
            } else {
                if ( sqrt < Math.pow(sqrt + 1, 2) - distance) {
                    System.out.println(sqrt * 2);
                } else {
                    System.out.println(sqrt * 2 + 1);
                }
            }
        }
    }
}
