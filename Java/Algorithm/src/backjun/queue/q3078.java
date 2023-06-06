package backjun.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class q3078 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<LinkedList<Friend>> lengths = new ArrayList<>();

        for (int i = 0; i <= 20; i++) {
            lengths.add(new LinkedList<>());
        }

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long answer = 0;

        for (int i = 0; i < n; i++) {
            String newFriendName = scanner.next();
            int length = newFriendName.length();

            LinkedList<Friend> queue = lengths.get(length);

            while (!queue.isEmpty() && i - queue.peekLast().rank > k){
                queue.pollLast();
            }

            answer += queue.size();
            queue.push(new Friend(i, newFriendName));
        }

        System.out.println(answer);
    }

    static class Friend {
        int rank;
        String name;

        Friend(int rank, String name) {
            this.rank = rank;
            this.name = name;
        }
    }
}
