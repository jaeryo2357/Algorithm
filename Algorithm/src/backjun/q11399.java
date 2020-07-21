package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class q11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];

        for (int index = 0; index < n; index++) {
            p[index] = scanner.nextInt();
        }

        Arrays.sort(p);
        int answer = p[0];
        for (int index = 1; index < n; index++) {
            p[index] += p[index - 1];
            answer += p[index];
        }

        System.out.println(answer);
    }
}
