package backjun.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class q1927 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (num == 0) {
                Integer number = queue.poll();
                if (number == null) number = 0;
                System.out.println(number);
            } else {
                queue.add(num);
            }
        }
    }
}
