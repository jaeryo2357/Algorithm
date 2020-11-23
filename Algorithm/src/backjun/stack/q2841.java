package backjun.stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class q2841 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        HashMap<Integer, Stack<Integer>> hash = new HashMap<>();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int position = scanner.nextInt();
            int flat = scanner.nextInt();

            Stack<Integer> stack = hash.get(position);
            if (stack == null) {
                stack = new Stack<>();
                stack.push(flat);
                hash.put(position, stack);
                answer++;
            } else {
                while (!stack.isEmpty() && stack.peek() > flat) {
                    stack.pop();
                    answer++;
                }
                if (stack.isEmpty() || stack.peek() != flat) {
                    stack.push(flat);
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
