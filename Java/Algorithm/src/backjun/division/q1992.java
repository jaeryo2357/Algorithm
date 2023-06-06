package backjun.division;

import java.util.Scanner;

public class q1992 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] board = new int[n][n];
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String numbers = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = numbers.charAt(j) - '0';
            }
        }
        StringBuilder builder = new StringBuilder();
        quardTree(n, 0, 0, board, builder);

        System.out.println(builder.toString());
    }

    public static void quardTree(int n, int startX, int startY, int[][] board, StringBuilder builder) {
        if (n == 0) {
            return;
        }

        int target = board[startY][startX];

        for (int h = startY; h < startY + n; h++) {
            for (int w = startX; w < startX + n; w++) {

                if (target != board[h][w]) {
                    builder.append("(");

                    quardTree(n / 2, startX, startY, board, builder);

                    quardTree(n / 2, startX + n / 2, startY, board, builder);

                    quardTree(n / 2, startX, startY + n / 2, board, builder);

                    quardTree(n / 2, startX + n / 2, startY + n / 2, board, builder);

                    builder.append(")");

                    return;
                }
            }
        }

        builder.append(target + "");
    }
}
