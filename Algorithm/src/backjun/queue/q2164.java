package backjun.queue;

import java.util.LinkedList;
import java.util.Scanner;

public class q2164 {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            queue.push(i);
        }

        while(queue.size() > 1) {
            queue.pollLast();

            Integer value = queue.pollLast();
            if (value != null) {
                queue.push(value);
            }
        }

        System.out.println(queue.pollFirst());
    }
}
