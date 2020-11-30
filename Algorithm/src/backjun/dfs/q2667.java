package backjun.dfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class q2667 {
    public static char[][] board;
    public static boolean[][] visited;

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        board = new char[n][n];
        visited = new boolean[n][n];


        LinkedList<Integer> town = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            board[i] = row.toCharArray();
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x] && board[y][x] == '1') {
                    int townCount = dfs(y, x);
                    town.add(townCount);
                }
            }
        }

        System.out.println(town.size());
        Collections.sort(town);

        for(Integer count : town) {
            System.out.println(count);
        }
    }

    public static int dfs(int startY, int startX) {
        visited[startY][startX] = true;

        int count = 1;
        //위
        if (startY - 1 >= 0 && !visited[startY - 1][startX] && board[startY - 1][startX] == '1') {
            count += dfs(startY - 1, startX);
        }

        //아래
        if (startY + 1 < board.length && !visited[startY + 1][startX] && board[startY + 1][startX] == '1') {
            count += dfs(startY + 1, startX);
        }

        //왼
        if (startX - 1 >= 0 && !visited[startY][startX - 1] && board[startY][startX - 1] == '1') {
            count += dfs(startY, startX - 1);
        }

        //위
        if (startX + 1 < board[startY].length && !visited[startY][startX + 1] && board[startY][startX + 1] == '1') {
            count += dfs(startY, startX + 1);
        }

        return count;
    }
}
