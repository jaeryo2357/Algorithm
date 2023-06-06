package backjun.dfs;

import java.util.Scanner;

public class q10026 {
    public static char[][] board;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        board = new char[n][n];
        visited = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }

        int answer = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x]) {

                    dfs(y, x, board[y][x] + "");
                    answer++;
                }
            }
        }

        System.out.printf("%d ", answer);

        answer = 0;

        visited = new boolean[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x]) {

                    if (board[y][x] == 'R' || board[y][x] == 'G') {
                        dfs(y, x, "RG");
                    } else {
                        dfs(y, x, board[y][x] + "");
                    }
                    answer++;
                }
            }
        }

        System.out.printf("%d", answer);
    }

    public static void dfs(int startY, int startX, String target) {
        visited[startY][startX] = true;

        //위
        if (startY - 1 >= 0 && !visited[startY - 1][startX] && target.contains(board[startY - 1][startX] + "")) {
            dfs(startY - 1, startX, target);
        }

        //아래
        if (startY + 1 < board.length && !visited[startY + 1][startX] && target.contains(board[startY + 1][startX] + "")) {
            dfs(startY + 1, startX, target);
        }

        //왼
        if (startX - 1 >= 0 && !visited[startY][startX - 1] && target.contains(board[startY][startX - 1] + "")) {
            dfs(startY, startX - 1, target);
        }

        //위
        if (startX + 1 < board[startY].length && !visited[startY][startX + 1] && target.contains(board[startY][startX + 1] + "")) {
            dfs(startY, startX + 1, target);
        }
    }
}
