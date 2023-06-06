package backjun;

import java.util.Scanner;

public class q11653 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 2;

        while (n != 1) {
            while (n % x == 0) {
                System.out.println(x);
                n /= x;
            }
            x++;
        }
    }
}
