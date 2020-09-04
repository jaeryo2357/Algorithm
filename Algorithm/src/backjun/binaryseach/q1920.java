package backjun.binaryseach;

import java.util.Arrays;
import java.util.Scanner;

public class q1920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            int target = scanner.nextInt();

            System.out.println(binary(arr, 0, arr.length - 1, target));
        }
    }

    public static int binary(int[] arr, int start, int end, int target) {
        if (start > end) {
            return 0;
        } else {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                return binary(arr, start, mid - 1, target);
            } else {
                return binary(arr, mid + 1, end, target);
            }
        }
    }
}
