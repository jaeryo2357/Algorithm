package backjun.bruteforce;

import java.util.Scanner;

public class q2661 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(backtrack("", n));
    }

    public static String backtrack(String value, int n) {
        if (value.length() == n) {
            return value;
        }

        //length = 7, 1232123
        // 2123 일때
        // 3 : 1, 2, 3  start = 2 end = 3
        // 12 : 31, 32, 33, start = 0 end = 2
        //
        for (int i = 1; i <= 3; i++) {

            boolean isAvailable = true;
            for (int j = 0; value.length() - j - 1 >= 0; j++) {

                String leftValue = value.substring(0, value.length() - j);
                String rightValue = value.substring(value.length() - j) + i;

                if (leftValue.endsWith(rightValue)) {
                    isAvailable = false;
                    break;
                }
            }

            if (isAvailable) {
                String answer = backtrack(value + i, n);
                if (!answer.isEmpty()) return answer;
            }
        }
        return "";
    }
}
