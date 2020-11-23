package backjun.stack;

import java.util.Scanner;
import java.util.Stack;

public class q3986 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Character> stack = new Stack<>();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            stack.clear();
            String s = scanner.next();

            for (int j = 0; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (!stack.isEmpty() && stack.peek() == temp) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }

            if (stack.size() == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
