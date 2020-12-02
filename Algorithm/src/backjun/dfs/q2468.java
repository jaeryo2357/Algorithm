package backjun.dfs;

import java.util.Scanner;

public class q2468 {
    public static int[][] board;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int answer = 0;
        for (int k = 0; k <= 100; k++) {
            int area = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] > k) {
                        dfs(i, j, k);
                        area++;
                    }
                }
            }

            answer = Math.max(answer, area);
        }

        System.out.println(answer);

    }

    public static void dfs(int startY, int startX, int waterHeight) {
        visited[startY][startX] = true;

        //위
        if (startY - 1 >= 0 && !visited[startY - 1][startX] && board[startY - 1][startX] > waterHeight) {
            dfs(startY - 1, startX, waterHeight);
        }

        //아래
        if (startY + 1 < board.length && !visited[startY + 1][startX] && board[startY + 1][startX] > waterHeight) {
            dfs(startY + 1, startX, waterHeight);
        }

        //왼
        if (startX - 1 >= 0 && !visited[startY][startX - 1] && board[startY][startX - 1] > waterHeight) {
            dfs(startY, startX - 1, waterHeight);
        }

        //위
        if (startX + 1 < board[startY].length && !visited[startY][startX + 1] && board[startY][startX + 1] > waterHeight) {
           dfs(startY, startX + 1, waterHeight);
        }
    }
}
