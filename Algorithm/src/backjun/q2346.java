package backjun;

import java.util.Scanner;

public class q2346 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        boolean[] check = new boolean[n];
        int[] balloon = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            balloon[i] = scanner.nextInt();
        }

        int position = 0;
        int boomCount = 0;
        while (boomCount < n - 1) {
            check[position] = true;
            answer[boomCount++] = position + 1;
            int nextPosition = position;
            for (int i = 0; i < Math.abs(balloon[position]); ) {
                if (balloon[position] > 0) {
                    nextPosition++;
                    nextPosition %= n;
                } else {
                    nextPosition--;
                    nextPosition = nextPosition < 0 ? nextPosition + n : nextPosition;
                }
                if (!check[nextPosition]) {
                    i++;
                }
            }

            position = nextPosition;
        }

        answer[n - 1] = position + 1;

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
