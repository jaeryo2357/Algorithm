package backjun;

import java.util.Scanner;
import java.util.Stack;

public class q1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n = scanner.nextInt();
        int index = 1;
        StringBuilder answerBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (stack.empty() || stack.peek() < num) {
                index = PushInStack(index, num, stack, answerBuilder);
            } else if (stack.peek() == num) {
                stack.pop();
                answerBuilder.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(answerBuilder.toString());
    }

    public static int PushInStack(int start, int end, Stack<Integer> stack, StringBuilder builder) {

        for (int num = start ; num <= end; num++) {
            stack.push(num);
            builder.append("+\n");
        }

        stack.pop();
        builder.append("-\n");
        return end + 1;
    }
}
