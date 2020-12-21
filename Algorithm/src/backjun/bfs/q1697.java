package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q1697 {
    private static boolean[] distance = new boolean[100001];
    private static boolean[] visited = new boolean[100001];
    private static LinkedList<Integer> queue = new LinkedList<>();
    private static LinkedList<Integer> tempQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        visited[n] = true;
        queue.addFirst(n);

        int k = scanner.nextInt();
        distance[k] = true;

        int time = 0;

        while (!queue.isEmpty()) {


            if (bfs(queue.removeLast())) break;

            if (queue.isEmpty() && !tempQueue.isEmpty()) {
                queue.addAll(tempQueue);
                tempQueue.clear();
                time++;
            }
        }
            System.out.println(time);
    }

    public static boolean bfs(int position) {
        if (distance[position]) {
            return true;
        }

        int upPosition = position + 1;
        if (upPosition < distance.length && !visited[upPosition]) {
            visited[upPosition] = true;
            tempQueue.addFirst(upPosition);
        }

        int downPosition = position - 1;
        if (downPosition >= 0 && !visited[downPosition]) {
            visited[downPosition] = true;
            tempQueue.addFirst(downPosition);
        }

        int jumpPosition = position * 2;
        if (jumpPosition < distance.length && !visited[jumpPosition]) {
            visited[jumpPosition] = true;
            tempQueue.addFirst(jumpPosition);
        }

        return false;
    }
}
