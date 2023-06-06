package backjun.queue;

import java.util.LinkedList;
import java.util.Scanner;

public class q11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        SequenceQueue queue = new SequenceQueue(n, k);

        System.out.println(queue.getSequence());
    }


    static class SequenceQueue extends LinkedList<Integer> {
        int n;
        int k;

        SequenceQueue(int n, int k) {
            this.n = n;
            this.k = k;

            initNumber();
        }

        private void initNumber() {
            for (int num = 1; num <= n; num++) {
                super.add(num);
            }
        }

        public String getSequence() {
            StringBuilder builder = new StringBuilder();
            builder.append("<");

            int removeIndex = k - 1;
            while (super.size() > 1) {
                int value = super.remove(removeIndex);

                builder.append(value + ", ");

                removeIndex = (removeIndex + k - 1) % super.size();
            }

            builder.append(super.pop() + ">");

            return builder.toString();
        }
    }
}
