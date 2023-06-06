package backjun.queue;

import java.util.LinkedList;
import java.util.Scanner;

public class q1966 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> queue = new LinkedList<>();
        int t = scanner.nextInt();

        while (t > 0) {
            queue.clear();

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int count = 0;

            for (int i = 0; i < n; i++) {
                int priority = scanner.nextInt();
                queue.add(priority);
            }

            while (queue.size() > 0) {

                boolean isHaveMorePriority = false;
                int targetPriority = queue.peek();

                for (Integer priority : queue) {
                    if (targetPriority < priority) {
                        isHaveMorePriority = true;
                    }
                }

                if (!isHaveMorePriority) {
                    count++;
                    int value = queue.pop();

                    if (m == 0) {
                        System.out.println(count);
                        break;
                    } else {
                        m--;
                    }
                } else {
                    queue.pop();
                    queue.add(targetPriority);

                    if (m == 0) {
                        m = queue.size() - 1;
                    } else {
                        m--;
                    }
                }
            }

            t--;
        }
    }
}
