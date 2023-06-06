package backjun;

import java.util.Scanner;

public class q1085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int min = x;
        int y = scanner.nextInt();
        if (y < min) {
            min = y;
        }
        int w = scanner.nextInt();
        if (w - x < min) {
            min = w - x;
        }
        int h = scanner.nextInt();
        if (h - y < min) {
            min = h - y;
        }
        System.out.println(min);
    }
}
