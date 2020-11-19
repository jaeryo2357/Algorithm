package backjun.list;

import java.util.LinkedList;
import java.util.Scanner;

public class q1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }
        StringBuilder answer = new StringBuilder();
        int removePosition = 0;
        while (!linkedList.isEmpty()) {
            removePosition = (removePosition + k - 1) % linkedList.size();
            answer.append(" " + linkedList.remove(removePosition) + ",");
        }

        answer.replace(0, 1, "<");
        answer.replace(answer.length() - 1, answer.length(), ">");

        System.out.println(answer);
    }

}
