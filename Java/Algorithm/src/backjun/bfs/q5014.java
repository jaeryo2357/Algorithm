package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q5014 {
    private static boolean[] floors;
    private static boolean[] visited;
    private static LinkedList<Integer> queue = new LinkedList<>();
    private static LinkedList<Integer> tempQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();

        floors = new boolean[f];
        visited = new boolean[f];

        int s = scanner.nextInt();
        visited[s - 1] = true;
        queue.addFirst(s - 1);

        int g = scanner.nextInt();
        floors[g - 1] = true;

        int u = scanner.nextInt();
        int d = scanner.nextInt();

        int time = 0;
        boolean isAvailable = false;

        while (!queue.isEmpty()) {

            isAvailable = bfs(queue.removeLast(), u, d);
            if (isAvailable) break;

            if (queue.isEmpty() && !tempQueue.isEmpty()) {
                queue.addAll(tempQueue);
                tempQueue.clear();
                time++;
            }
        }

        if (isAvailable) {
            System.out.println(time);
        } else {
            System.out.println("use the stairs");
        }
    }

    public static boolean bfs(int floor, int u, int d) {
        if (floors[floor]) {
            return true;
        }

        int upPosition = floor + u;
        if (upPosition < floors.length && !visited[upPosition]) {
            visited[upPosition] = true;
            tempQueue.addFirst(upPosition);
        }

        int downPosition = floor - d;
        if (downPosition >= 0 && !visited[downPosition]) {
            visited[downPosition] = true;
            tempQueue.addFirst(downPosition);
        }

        return false;
    }
}
