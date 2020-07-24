package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class q1037 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];

        for (int index = 0; index < n; index++) {
            nums[index] = scanner.nextInt();
        }

        Arrays.sort(nums);

        System.out.println(nums[0] * nums[n - 1]);
    }
}
