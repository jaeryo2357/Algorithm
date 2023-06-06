package backjun;

import java.util.Scanner;

public class q7568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] person = new int[n][2];

        for (int t = 0; t < n; t++) {
            person[t][0] = scanner.nextInt();
            person[t][1] = scanner.nextInt();
        }

        for (int t = 0; t < n; t++) {
            int betterPerson = 0;
            for (int i = 0; i < n; i++) {
                if (t != i && person[i][0] > person[t][0] && person[i][1] > person[t][1]) {
                    betterPerson++;
                }
            }
            betterPerson += 1;
            System.out.print(betterPerson + " ");
        }
    }
}
