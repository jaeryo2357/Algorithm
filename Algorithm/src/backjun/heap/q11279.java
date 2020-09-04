package backjun.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class q11279 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<MyInteger> heap = new PriorityQueue<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (num == 0) {
                if (heap.isEmpty()) {
                    System.out.println(0);
                } else {
                    MyInteger number = heap.remove();
                    System.out.println(number);
                }
            } else {
                heap.add(new MyInteger(num));
            }
        }
    }

    static class MyInteger  implements Comparable<MyInteger> {
        int value;

        public MyInteger(int value) {
           this.value = value;
        }

        @Override
        public int compareTo(MyInteger o) {
            return o.value - this.value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }
}
