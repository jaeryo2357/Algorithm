package backjun.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        LinkedList<Character> linkedList = new LinkedList<>();
        ListIterator<Character> iterator = linkedList.listIterator();
        for (int i = 0; i < s.length(); i++) {
            iterator.add(s.charAt(i));
        }

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String action = reader.readLine();

            if (action.equals("L")) {
                if (iterator.hasPrevious()) iterator.previous();
            } else if (action.equals("D")) {
                if (iterator.hasNext()) iterator.next();
            } else if (action.equals("B")) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else {
                String[] splits = action.split(" ");
                iterator.add(splits[1].charAt(0));
            }
        }

        StringBuilder builder = new StringBuilder();

        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            builder.append(linkedList.remove());
        }

        System.out.println(builder.toString());
    }
}
