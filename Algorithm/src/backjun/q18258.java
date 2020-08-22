package backjun;

import java.io.*;
import java.util.ArrayDeque;

public class q18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String run = reader.readLine();

            if (run.equals("pop")) {
                int value = queue.isEmpty() ? -1 : queue.pollLast();
                writer.write(value + "\n");
            } else if (run.equals("size")) {
                writer.write(queue.size() + "\n");
            } else if (run.equals("empty")) {
                int value = queue.isEmpty() ? 1 : 0;
                writer.write(value + "\n");
            } else if (run.equals("front")) {
                int value = queue.isEmpty() ? -1 : queue.peekLast();
                writer.write(value + "\n");
            } else if (run.equals("back")) {
                int value = queue.isEmpty() ? -1 : queue.peekFirst();
                writer.write(value + "\n");
            } else {
                int value = Integer.parseInt(run.split(" ")[1]);
                queue.push(value);
            }
        }

        writer.close();
    }
}
