package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q5427 {
    public static final int[] move = new int[]{0, 0, 1, -1};
    public static char[][] board;
    public static boolean[][] visited;

    public static LinkedList<Point> personQueue;
    public static LinkedList<Point> personTempQueue;

    public static LinkedList<Point> fireQueue;
    public static LinkedList<Point> fireTempQueue;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            boolean answer = false;
            int time = 0;

            //TODO: 변수 board visited 초기화
            int w = scanner.nextInt();
            int h = scanner.nextInt();

            board = new char[h][w];
            visited = new boolean[h][w];

            personQueue = new LinkedList<>();
            personTempQueue = new LinkedList<>();

            fireQueue = new LinkedList<>();
            fireTempQueue = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String value = scanner.next();
                board[i] = value.toCharArray();

                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '@') {
                        personQueue.addFirst(new Point(j, i));
                    } else if (board[i][j] == '*') {
                        fireQueue.addFirst(new Point(j, i));
                    }
                }
            }



            while (personQueue != null && personQueue.size() > 0) {

                Point person = personQueue.removeLast();

                while (fireQueue != null && fireQueue.size() > 0) {
                    bfs(fireTempQueue, fireQueue.removeLast());
                }

                answer = bfs(personTempQueue, person);
                if (answer) {
                    break;
                }

                if (personQueue.size() == 0 ) {

                    if (personTempQueue.size() > 0){
                        personQueue.addAll(personTempQueue);
                        personTempQueue.clear();
                        time++;
                    }
                    if (fireQueue.size() == 0 && fireTempQueue.size() > 0) {
                        fireQueue.addAll(fireTempQueue);
                        fireTempQueue.clear();
                    }
                }
            }


            if (answer) {
                System.out.println(time + 1);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static boolean bfs(LinkedList<Point> queue, Point point) {

        if (board == null || visited == null) {
            return false;
        }

        boolean answer = false;

        for (int i = 0; i < 4; i++) {
            int nextX = point.x + move[i];
            int nextY = point.y + move[3 - i];

            if (nextY < 0 || nextY >= board.length ||
                    nextX < 0 || nextX >= board[nextY].length) {
                answer =  true;
            } else if (!visited[nextY][nextX] && board[nextY][nextX] == '.') {
                visited[nextY][nextX] = true;
                queue.addFirst(new Point(nextX, nextY));
            }
        }

        return answer;
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
