package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q7569 {
    public static int[] move = new int[] {0, 0, 1, -1};
    public static int[][][] board;
    public static boolean[][][] visited;
    public static LinkedList<Point> queue = new LinkedList<>();
    public static LinkedList<Point> tempQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int h = scanner.nextInt();

            int emptySize = 0;

            board = new int[n][m][h];
            visited = new boolean[n][m][h];

            for (int height = 0; height < h; height++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        board[i][j][height] = scanner.nextInt();

                        if (board[i][j][height] == 1) {
                            queue.addFirst(new Point(height, j, i));
                            visited[i][j][height] = true;
                        } else if (board[i][j][height] == -1) {
                            emptySize++;
                        }
                    }
                }
            }


            int time = 0;
            int size = 0;

            while(queue.size() > 0) {
                size++;
                Point nextPoint = queue.removeLast();
                bfs(nextPoint.floor, nextPoint.y, nextPoint.x);

                if (queue.size() == 0 && tempQueue.size() > 0) {
                    queue.addAll(tempQueue);
                    tempQueue.clear();
                    time++;
                }
            }

            if (size == m * n * h - emptySize) {
                System.out.println(time);
            } else {
                System.out.println(-1);
            }

    }

    public static void bfs(int floor, int y, int x) {

        for (int i = 0; i < 4; i++) {
            int nextY = y + move[i];
            int nextX = x + move[3 - i];

            if ( nextY >= 0 && nextY < board.length
                    && nextX >= 0 && nextX < board[nextY].length
                    && !visited[nextY][nextX][floor]
                    && board[nextY][nextX][floor] == 0) {

                visited[nextY][nextX][floor] = true;
                tempQueue.addFirst(new Point(floor, nextX, nextY));
            }
        }

        if (floor - 1 >= 0 && !visited[y][x][floor - 1]
                && board[y][x][floor - 1] == 0) {
            visited[y][x][floor - 1] = true;
            tempQueue.addFirst(new Point(floor - 1, x, y));
        }

        if (floor + 1 < visited[y][x].length && !visited[y][x][floor + 1]
                && board[y][x][floor + 1] == 0) {
            visited[y][x][floor + 1] = true;
            tempQueue.addFirst(new Point(floor + 1, x, y));
        }
    }

    static class Point {
        int floor;
        int y;
        int x;

        public Point(int floor, int x, int y) {
            this.floor = floor;
            this.x = x;
            this.y = y;
        }
    }
}
