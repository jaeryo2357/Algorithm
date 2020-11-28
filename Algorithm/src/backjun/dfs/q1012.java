package backjun.dfs;

import java.util.Scanner;

public class q1012 {
    public static int[][] board;
    public static boolean[][] visited;

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();


        for (int i = 0; i < t; i++) {

            int m = scanner.nextInt();
            int n = scanner.nextInt();

            board = new int[n][m];
            visited = new boolean[n][m];

            int k = scanner.nextInt();

            int answer = 0;

            for (int j = 0; j < k; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                board[y][x] = 1;
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (!visited[y][x] && board[y][x] == 1) {
                        dfs(y, x);
                        answer++;
                    }
                }
            }

            System.out.println(answer);

        }
    }

    public static void dfs(int startY, int startX) {
        visited[startY][startX] = true;

        //위
        if (startY - 1 >= 0 && !visited[startY - 1][startX] && board[startY - 1][startX] == 1) {
            dfs(startY - 1, startX);
        }

        //아래
        if (startY + 1 < board.length && !visited[startY + 1][startX] && board[startY + 1][startX] == 1) {
            dfs(startY + 1, startX);
        }

        //왼
        if (startX - 1 >= 0 && !visited[startY][startX - 1] && board[startY][startX - 1] == 1) {
            dfs(startY, startX - 1);
        }

        //위
        if (startX + 1 < board[startY].length && !visited[startY][startX + 1] && board[startY][startX + 1] == 1) {
            dfs(startY, startX + 1);
        }
    }
}
