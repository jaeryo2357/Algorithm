package backjun;

import java.util.Scanner;

public class q3053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();

        System.out.printf("%.6f\n", Math.pow(r, 2) * Math.PI);
        System.out.printf("%.6f\n", Math.pow(r, 2) * 2);
    }
}
