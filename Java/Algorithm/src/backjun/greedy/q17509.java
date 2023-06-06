package backjun.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q17509 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] inputs = new int[11][11];

        for (int i = 0; i < 11; i++) {
            inputs[i][0] = scanner.nextInt();
            inputs[i][1] = scanner.nextInt();
        }

        Arrays.sort(inputs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int t = 0;
        int answer = 0;

        for (int i = 0; i < 11; i++) {
            t += inputs[i][0];
            answer += t + 20 * inputs[i][1];
        }

        System.out.println(answer);
    }
}
