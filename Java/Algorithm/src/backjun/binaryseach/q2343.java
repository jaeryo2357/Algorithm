package backjun.binaryseach;

import java.util.Scanner;

public class q2343 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] lengths = new int[n];
        long maxSize = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            lengths[i] = scanner.nextInt();
            maxLength = Math.max(lengths[i], maxLength);
            maxSize += lengths[i];
        }

        long minSize = maxLength;
        long answer = 0;
        while (minSize <= maxSize) {
            long middleSize = (minSize + maxSize) / 2;

            long size = 0;
            int length = 1;

            for (int i = 0; i < n; i++) {
                if (size + lengths[i] <= middleSize) {
                    size += lengths[i];
                } else {
                    length++;
                    size = lengths[i];
                }
            }

            if (length <= m) {
                answer = middleSize;
                maxSize = middleSize - 1;
            } else {
                minSize = middleSize + 1;
            }
        }

        System.out.println(answer);
    }
}
