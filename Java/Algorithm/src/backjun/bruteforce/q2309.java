package backjun.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class q2309 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] height = new int[9];

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            height[i] = scanner.nextInt();
            sum += height[i];
        }

        Arrays.sort(height);

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {

                if (sum - height[i] - height[j] == 100) {

                    for (int k = 0; k < height.length; k++) {
                        if (i != k && j != k) {
                            System.out.println(height[k]);

                        }
                    }
                    return;
                }
            }
        }


    }
}
