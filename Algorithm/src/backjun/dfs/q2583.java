package backjun.dfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class q2583 {
    public static int[][] board;
    public static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        board = new int[m][n];
        visited = new boolean[m][n];

        int k = scanner.nextInt();

        for (int i = 0; i < k; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();

            int x2 = scanner.nextInt() - 1;
            int y2 = scanner.nextInt() - 1;


            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 1;
                }
            }
        }

        LinkedList<Integer> areas = new LinkedList<>();

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x] && board[y][x] == 0) {
                    areas.add(dfs(y, x));
                }
            }
        }

        Collections.sort(areas);

        System.out.println(areas.size());

        for (Integer area : areas) {
            System.out.print(area + " ");
        }
    }

    public static int dfs(int startY, int startX) {
        visited[startY][startX] = true;

        int count = 1;
        //위
        if (startY - 1 >= 0 && !visited[startY - 1][startX] && board[startY - 1][startX] == 0) {
            count += dfs(startY - 1, startX);
        }

        //아래
        if (startY + 1 < board.length && !visited[startY + 1][startX] && board[startY + 1][startX] == 0) {
            count += dfs(startY + 1, startX);
        }

        //왼
        if (startX - 1 >= 0 && !visited[startY][startX - 1] && board[startY][startX - 1] == 0) {
            count += dfs(startY, startX - 1);
        }

        //위
        if (startX + 1 < board[startY].length && !visited[startY][startX + 1] && board[startY][startX + 1] == 0) {
            count += dfs(startY, startX + 1);
        }

        return count;
    }
}
