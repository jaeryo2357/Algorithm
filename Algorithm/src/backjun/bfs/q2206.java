package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q2206 {
    static int[] move = new int[]{0, 0, 1, -1};
    static boolean[][][] visited;
    static char[][] board;
    static LinkedList<Point> queue = new LinkedList<>();
    static LinkedList<Point> tempQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();

        visited = new boolean[n][m][2];
        board = new char[n][m];

        for (int i = 0 ; i < n; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }

        queue.addFirst(new Point(0, 0, true));
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        int time = 0;
        boolean isAvailable = false;

        while(queue.size() > 0) {

            isAvailable = bfs(queue.removeLast());
            if (isAvailable) {
                break;
            }

            if (queue.isEmpty() && tempQueue.size() > 0) {
                time++;
                queue.addAll(tempQueue);
                tempQueue.clear();
            }
        }

        if (isAvailable) {
            System.out.println(time + 1);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean bfs(Point point) {

        if (point.y == board.length - 1 && point.x == board[point.y].length - 1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = point.y + move[i];
            int nextX = point.x + move[3 - i];

            if (nextY >= 0 && nextY < board.length && nextX >= 0 && nextX < board[nextY].length) {

                if (board[nextY][nextX] == '1' && point.isBroken && !visited[nextY][nextX][1]) {
                    visited[nextY][nextX][1] = true;

                    tempQueue.addFirst(new Point(nextX, nextY, false));
                } else if (board[nextY][nextX] == '0'){
                    if (!visited[nextY][nextX][0] && point.isBroken) {
                        visited[nextY][nextX][0] = true;

                        tempQueue.addFirst(new Point(nextX, nextY, true));
                    } else if (!visited[nextY][nextX][1] && !point.isBroken) {
                        visited[nextY][nextX][1] = true;

                        tempQueue.addFirst(new Point(nextX, nextY, false));
                    }
                }
            }
        }

        return false;
    }


    static class Point {
        int x;
        int y;
        boolean isBroken;

        Point(int x, int y, boolean isBroken) {
            this.x = x;
            this.y = y;
            this.isBroken = isBroken;
        }
    }
}
