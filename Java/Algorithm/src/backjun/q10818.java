package backjun;

import java.util.Scanner;
import java.util.Arrays;

public class q10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for (int t = 0; t < size; t++) {
            arr[t] = scanner.nextInt();
        }

        Arrays.sort(arr);

        System.out.printf("%d %d",arr[0],arr[size - 1]);
    }
}
