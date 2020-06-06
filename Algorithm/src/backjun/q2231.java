package backjun;

import java.util.Scanner;

public class q2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int min = n + 1;

        for (int t = 0; t < n; t++) {
            String number = "" + t;
            int result = t;
            for (int i = 0; i < number.length(); i++) {
                result += number.charAt(i) - '0';
            }
            if (result == n && result < min) {
                min = t;
            }
        }

        if (min == n + 1) {
            min = 0;
        }
        System.out.println(min);
    }
}
