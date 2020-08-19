package backjun;

import java.util.Scanner;
import java.util.Stack;

public class q9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        Stack<String> stack = new Stack<>();

        for (int i = 0;i < t; i++) {
            stack.clear();

            String question = scanner.nextLine().trim();

            for (int j = 0; j < question.length(); j++) {
                String c = question.charAt(j) + "";

                if (!stack.empty() && c.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.size() > 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
