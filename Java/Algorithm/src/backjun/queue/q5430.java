package backjun.queue;

import java.util.LinkedList;
        import java.util.Collections;
        import java.util.Scanner;

public class q5430 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            queue.clear();
            String run = scanner.nextLine();

            boolean isError = false;
            int reverseCount = 0;

            int size = scanner.nextInt();

            scanner.nextLine();
            String num = scanner.nextLine();
            String[] numArray = num.substring(1, num.length() -1).split(",");

            for (int j = 0; j < size; j++) {
                queue.add(Integer.parseInt(numArray[j]));
            }


            for (int j = 0; j < run.length(); j++) {

                if (run.charAt(j) == 'D') {
                    if (queue.size() > 0) {
                        if (reverseCount % 2 == 0) {
                            queue.remove(0);
                        } else {
                            queue.remove(queue.size() - 1);
                        }
                    } else {
                        isError = true;
                        break;
                    }
                } else {
                    reverseCount += 1;
                }
            }

            if (!isError) {
                if (reverseCount % 2 == 1) {
                    Collections.reverse(queue);
                }
                StringBuilder builder = new StringBuilder();
                builder.append("[");

                for (int j = 0; j < queue.size();) {
                    builder.append(queue.remove(j));
                    if (j < queue.size()) {
                        builder.append(",");
                    }
                }
                builder.append("]");
                System.out.println(builder.toString());
            } else {
                System.out.println("error");
            }
        }
    }
}
