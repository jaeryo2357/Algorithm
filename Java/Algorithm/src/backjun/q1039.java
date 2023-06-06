package backjun;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class q1039 {

    public static HashSet<Integer> visited = new HashSet<>();
    public static LinkedList<Integer> queue = new LinkedList<>();
    public static LinkedList<Integer> tempQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();


        queue.addFirst(n);

        int time = 0;
        int answer = 0;

        while(!queue.isEmpty() && time < k) {

            bfs(queue.removeLast());


            if (queue.isEmpty() && !tempQueue.isEmpty()) {
                time++;
                queue.addAll(tempQueue);
                tempQueue.clear();
                visited.clear();

            }
        }

        while (!queue.isEmpty()) {
            answer = Math.max(queue.removeLast(), answer);
        }

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void bfs(int n) {
        String number = String.valueOf(n);

        for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j < number.length(); j++) {
                StringBuilder builder = new StringBuilder();
                for (int c = 0; c < number.length(); c++) {
                    if (c == i) {
                        builder.append(number.charAt(j));
                    } else if (c == j) {
                        builder.append(number.charAt(i));
                    } else {
                        builder.append(number.charAt(c));
                    }
                }

                int value = Integer.parseInt(builder.toString());

                if (!visited.contains(value) && !builder.toString().startsWith("0")) {
                    visited.add(value);
                    tempQueue.addFirst(value);
                }
            }
        }
    }
}
