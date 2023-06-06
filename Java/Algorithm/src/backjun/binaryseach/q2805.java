package backjun.binaryseach;

import java.util.Arrays;
import java.util.Scanner;

public class q2805 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long m = scanner.nextLong();

        long[] tree = new long[n];

        long max = 0;


        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextLong();

            max = Math.max(max, tree[i]);
        }


        Arrays.sort(tree);
        long answer = 0;
        long min = 0;
        while(min <= max) {
            long middle = (min + max) / 2;

            long count = 0;

            for (int i = 0; i < n; i++) {
                if (tree[i] > middle) {
                    count += tree[i] - middle;
                }
            }

            if (count >= m) {
                answer = Math.max(answer, middle);
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }

        System.out.println(answer);
    }
}
