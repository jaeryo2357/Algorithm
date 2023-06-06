package backjun.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q13904 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] subject = new int[n][2];
        int[] days = new int[1001];

        for (int i = 0; i < n; i++) {
            subject[i][0] = scanner.nextInt();
            subject[i][1] = scanner.nextInt();
        }

        Arrays.sort(subject, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });


        for (int i = 0; i < n; i++) {

            if (days[subject[i][0]] == 0) {
                days[subject[i][0]] = subject[i][1];
            } else {
                int idx = subject[i][0];
                while(idx >= 1) {
                    if (days[idx] == 0) {
                        days[idx] = subject[i][1];
                        break;
                    }
                    idx--;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 1000; i++) {
            answer += days[i];
        }

        System.out.println(answer);
    }
}
