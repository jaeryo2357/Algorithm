package backjun;

import java.util.Scanner;

public class q2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int range = 1;
        int line = 1;

        while (n > range) {
            range = range + 6 * line++;
        }

        System.out.println(line);
    }
}
