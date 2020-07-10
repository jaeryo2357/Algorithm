package backjun;

import java.util.Scanner;

public class q11054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        int[][] saveLength = new int[n][2];

        for (int index = 0; index < n; index++) {
            nums[index] = scanner.nextInt();
        }

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    saveLength[i][0] = Math.max(saveLength[i][0], saveLength[j][0] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {

            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    saveLength[i][1] = Math.max(saveLength[i][1], saveLength[j][1] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
                int length = saveLength[i][0] + saveLength[i][1] + 1;
                result = Math.max(result, length);
        }

        System.out.println(result);
    }
}
