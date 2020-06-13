package backjun;

import java.util.Scanner;

public class q9663 {
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] board = new int[n][n];

        placeQueen(board, 0, n);

        System.out.println(result);
    }

    public static void placeQueen(int[][] board, int num, int max) {

        if (num >= max) {
            result++;
            return;
        }

        for (int width = 0; width < board[num].length; width++) {
            if (board[num][width] != 1) {
                board[num][width] = 1;

                if (isAttack(board, width, num)) {
                    placeQueen(board, num + 1, max);
                }

                board[num][width] = 0;
            }
        }

    }

    public static boolean isAttack(int[][] board, int width, int height) {

        //오른쪽
        for (int right = width + 1; right < board[0].length; right++) {
            if (board[height][right] == 1) {
                return false;
            }
        }

        //왼쪽
        for (int left = width - 1; left >= 0; left--) {
            if (board[height][left] == 1) {
                return false;
            }
        }

        //위
        for (int up = height - 1; up >= 0; up--) {
            if (board[up][width] == 1) {
                return false;
            }
        }

        //아래
        for (int down = height + 1; down < board.length; down++) {
            if (board[down][width] == 1) {
                return false;
            }
        }

        //아래 오른쪽 대각선

        for (int down = height + 1, right = width + 1; down < board.length && right < board[0].length; down++, right++) {
            if (board[down][right] == 1) {
                return false;
            }
        }

        //위 오른쪽 대각선

        for (int up = height - 1, right = width + 1; up >= 0 && right < board[0].length; up--, right++) {
            if (board[up][right] == 1) {
                return false;
            }
        }

        //위 왼쪽 대각선

        for (int up = height - 1, left = width - 1; up >= 0 && left >= 0; up--, left--) {
            if (board[up][left] == 1) {
                return false;
            }
        }

        //아래 왼쪽 대각선

        for (int down = height + 1, left = width - 1; down < board.length && left >= 0; down++, left--) {
            if (board[down][left] == 1) {
                return false;
            }
        }

        return true;
    }
}
