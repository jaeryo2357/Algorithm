package backjun.dynamic;

import java.util.Scanner;

public class q2565 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] line = new int[500 + 1];
        int maxLine = 0;

        for (int i = 0; i < n; i++) {
            int index = scanner.nextInt();
            int value = scanner.nextInt();

            maxLine = Math.max(maxLine, index);
            maxLine = Math.max(maxLine, value);

            line[index] = value;
        }

        int[] saveLength = new int[maxLine + 1];

        for (int index = 1; index <= maxLine; index++) {
            for (int range = 0; range < index; range++) {
                if (line[index] > line[range]) {
                    saveLength[index] = Math.max(saveLength[index], saveLength[range] + 1);
                }
            }
        }
        int result = 0;

        for (int index = 1; index <= maxLine; index++) {
            result = Math.max(saveLength[index], result);
        }

        System.out.println(n - result);
    }
}
