package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q7562 {
    private static final int[] d = new int[] {1, -1};
    private static final int[] move = new int[] {2, 1, -2, -1, 2, 1, 2, 1};
    private static boolean[] board;
    private static boolean[] visited;
    private static LinkedList<Integer> queue = new LinkedList<>();
    private static LinkedList<Integer> tempQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            int l = scanner.nextInt();

            board = new boolean[l * l];
            visited = new boolean[l * l];
            queue.clear();
            tempQueue.clear();

            int startPosition = scanner.nextInt() * l + scanner.nextInt();
            visited[startPosition] = true;
            queue.addFirst(startPosition);

            int endPosition = scanner.nextInt() * l + scanner.nextInt();
            board[endPosition] = true;

            int time = 0;
            while (!queue.isEmpty()) {

                if (bfs(queue.removeLast(), l)) {
                    break;
                }

                if (queue.isEmpty() && !tempQueue.isEmpty()) {
                    queue.addAll(tempQueue);
                    tempQueue.clear();
                    time++;
                }
            }

            System.out.println(time);
        }
    }

    public static boolean bfs(int position, int l) {
        if (board[position]) {
            return true;
        }

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < move.length / 2; i++) {
                int nextY = (position / l) + (move[i] * d[j]);

                int nextX = (position % l) + (move[move.length - i - 1] * d[j]);

                int nextPosition = nextY * l + nextX;

                if (nextY >= 0 && nextY < l && nextX >= 0 && nextX < l) {
                    if (!visited[nextPosition]) {
                        visited[nextPosition] = true;
                        tempQueue.addFirst(nextPosition);
                    }
                }
            }
        }
        return false;
    }
}
