package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class q1449 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;
        int position = 0;

        for (int i = 0; i < n; i++) {
            if (position < arr[i]) {
                position = arr[i] + l - 1;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
