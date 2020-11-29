package backjun.dfs;

import java.util.Scanner;

public class q1743 {
    public static boolean[][] board;
    public static boolean[][] visited;

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            board = new boolean[n][m];
            visited = new boolean[n][m];

            int k = scanner.nextInt();

            int answer = 0;

            for (int j = 0; j < k; j++) {
                int y = scanner.nextInt() - 1;
                int x = scanner.nextInt() - 1;

                board[y][x] = true;
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (!visited[y][x] && board[y][x]) {
                        answer = Math.max(dfs(y, x), answer);
                    }
                }
            }

            System.out.println(answer);

    }

    public static int dfs(int startY, int startX) {
        visited[startY][startX] = true;

        int count = 1;
        //위
        if (startY - 1 >= 0 && !visited[startY - 1][startX] && board[startY - 1][startX]) {
            count += dfs(startY - 1, startX);
        }

        //아래
        if (startY + 1 < board.length && !visited[startY + 1][startX] && board[startY + 1][startX]) {
            count += dfs(startY + 1, startX);
        }

        //왼
        if (startX - 1 >= 0 && !visited[startY][startX - 1] && board[startY][startX - 1]) {
            count += dfs(startY, startX - 1);
        }

        //위
        if (startX + 1 < board[startY].length && !visited[startY][startX + 1] && board[startY][startX + 1]) {
            count += dfs(startY, startX + 1);
        }

        return count;
    }
}
