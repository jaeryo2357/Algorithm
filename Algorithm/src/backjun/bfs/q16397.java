package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q16397 {
    public static boolean[] visited = new boolean[1000000];
    public static LinkedList<Integer> queue = new LinkedList<>();
    public static LinkedList<Integer> tempQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int g = scanner.nextInt();

        queue.addFirst(n);
        visited[n] = true;

        int time = 0;
        boolean isAvailable = false;

        while (!queue.isEmpty() && time <= t) {

            isAvailable = bfs(queue.removeLast(), g);
            if (isAvailable) {
                break;
            }

            if (queue.isEmpty() && !tempQueue.isEmpty()) {
                queue.addAll(tempQueue);
                tempQueue.clear();
                time++;
            }
        }

        if (isAvailable) {
            System.out.println(time);
        } else {
            System.out.println("ANG");
        }
    }

    public static boolean bfs(int n, int g) {
        if (n == g) {
            return true;
        } else {

            //A
            if (n + 1 <= 99999 && !visited[n + 1]) {
                tempQueue.addFirst(n + 1);
                visited[n + 1] = true;
            }
            //B

            if (n * 2 > 99999) {
                return false;
            }

            int bValue = n * 2;
            int minusValue = 100000;

            while(bValue < minusValue) {
                minusValue /= 10;
            }

            bValue -= minusValue;

            if (!visited[bValue]) {
                tempQueue.addFirst(bValue);
                visited[bValue] = true;
            }

            return false;
        }
    }
}
