package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q3055 {
    public static int[] move = new int[] {0, 0, 1, -1};
    public static boolean[][] visited;
    public static char[][] board;
    public static LinkedList<Point> animalQueue = new LinkedList<>();
    public static LinkedList<Point> animalTempQueue = new LinkedList<>();
    public static LinkedList<Point> waterQueue = new LinkedList<>();
    public static LinkedList<Point> waterTempQueue = new LinkedList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        board = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            board[i] = scanner.next().toCharArray();

            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'S') {
                    animalQueue.addFirst( new Point(j, i));
                } else if (board[i][j] == '*') {
                    waterQueue.addFirst(new Point(j, i));
                }
            }
        }

        int time = 0;
        boolean isAvailable = false;

        while (animalQueue.size() > 0) {

            while (waterQueue.size() > 0) {
                Point waterPosition = waterQueue.removeLast();

                bfs(waterPosition.y, waterPosition.x, waterTempQueue, true);
            }

            Point animalPosition = animalQueue.removeLast();

            isAvailable = bfs(animalPosition.y, animalPosition.x, animalTempQueue, false);
            if (isAvailable) {
                break;
            }

            if (animalQueue.size() == 0 && animalTempQueue.size() > 0) {
                time++;
                animalQueue.addAll(animalTempQueue);
                animalTempQueue.clear();

                waterQueue.addAll(waterTempQueue);
                waterTempQueue.clear();
            }
        }

        if (isAvailable) {
            System.out.println(time + 1);
        } else {
            System.out.println("KAKTUS");
        }
    }

    public static boolean bfs(int r, int c, LinkedList<Point> queue, boolean isWater) {

        if (!isWater) {
            board[r][c] = '.';
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + move[i];
            int nextC = c + move[3 - i];

            if (nextR >= 0 && nextR < board.length && nextC >= 0 && nextC < board[nextR].length
             && !visited[nextR][nextC]) {

                if (board[nextR][nextC] == 'D' && !isWater) {
                    return true;
                } else if (board[nextR][nextC] == '.'){
                    visited[nextR][nextC] = true;
                    queue.addFirst(new Point(nextC, nextR));
                }
            }
        }

        return false;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
