package backjun;

import java.util.Scanner;

public class q2562 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = -1;
        int maxIndex  = 0;

        for (int t = 0; t < 9; t++) {
            int n = scanner.nextInt();
            if (max < n) {
                max = n;
                maxIndex = t + 1;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }
}
