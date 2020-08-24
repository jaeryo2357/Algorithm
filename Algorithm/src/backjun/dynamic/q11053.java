package backjun.dynamic;

import java.util.Scanner;

public class q11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        int[][] saveLength = new int[n][1001];

        for (int index = 0; index < n; index++) {
            nums[index] = scanner.nextInt();
        }

        System.out.println(findLongLength(0, 0, nums, saveLength));
    }

    public static int findLongLength(int value, int index, int[] nums, int[][] saveLength) {
        if (index >= nums.length) {
            return 0;
        } else if (saveLength[index][value] != 0) {
            return saveLength[index][value];
        } else {
            int max = 0;

            for (int nextIndex = index; nextIndex < nums.length; nextIndex++) {
                if (nums[nextIndex] > value) {

                    //선택한 경우
                    int tempLength = 1 + findLongLength(nums[nextIndex], nextIndex + 1, nums, saveLength);

                    max = Math.max(max, tempLength);

                    //선택 안할 경우
                    tempLength = findLongLength(value, nextIndex + 1, nums, saveLength);

                    max = Math.max(max, tempLength);
                }
            }

            saveLength[index][value] = max;
            return max;
        }
    }
}
