package backjun.queue;

import java.io.*;
import java.util.LinkedList;

public class q10866 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> deque = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());


        //add가 뒤에, push가 앞에
        //pop이 앞에서
        for (int i = 0; i < n; i++) {
            String run = reader.readLine();

            if (run.equals("size")) {
                writer.write(deque.size() + "\n");
            } else if (run.equals("empty")) {
                int value = deque.isEmpty() ? 1 : 0;
                writer.write(value + "\n");
            } else if (run.equals("front")) {
                int value = deque.isEmpty() ? -1 : deque.peekFirst();
                writer.write(value + "\n");
            } else if (run.equals("back")) {
                int value = deque.isEmpty() ? -1 : deque.peekLast();
                writer.write(value + "\n");
            } else if (run.equals("pop_front")) {
                Integer value = deque.isEmpty() ? -1 : deque.pollFirst();
                writer.write(value + "\n");
            } else if (run.equals("pop_back")) {
                Integer value = deque.isEmpty() ? -1 : deque.pollLast();
                writer.write(value + "\n");
            } else {
                String[] runArray = run.split(" ");
                int value = Integer.parseInt(runArray[1]);

                if (runArray[0].equals("push_front")) {
                    deque.push(value);
                } else {
                    deque.add(value);
                }
            }
        }

        writer.close();
    }
}
