package backjun.division;

import java.util.Scanner;

public class q2630 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] board = new int[n][n];
        // 0 index = 하얀색, 1은 파란색
        int[] answer = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        checkBoard(n, 0, 0, answer, board);
        System.out.printf("%d\n%d", answer[0], answer[1]);
    }

    public static void checkBoard(int n, int startX, int startY, int[] answer, int[][] board) {
        if (n != 0) {
            int target = board[startY][startX];

            for (int y = startY; y < startY + n; y++) {
                for (int x = startX; x < startX + n; x++) {

                    if (target != board[y][x]) {

                        //왼위
                        checkBoard(n / 2, startX, startY, answer, board);

                        //오위
                        checkBoard(n / 2, startX + n / 2, startY, answer, board);

                        //왼아
                        checkBoard(n / 2, startX, startY + n / 2, answer, board);

                        //우아
                        checkBoard(n / 2, startX + n / 2, startY + n / 2, answer, board);

                       return;
                    }
                }
            }

            //파란색
            if (target == 1) {
                answer[1] += 1;
            } else {
                answer[0] += 1;
            }
        }
    }
}
