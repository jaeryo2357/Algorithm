package backjun.stack;

import java.util.Scanner;
import java.util.Stack;

public class q4949 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        while (scanner.hasNextLine()) {
            stack.clear();
            String str = scanner.nextLine();
            boolean isSafe = true;

            if (str.equals(".")) {
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                String s = str.charAt(i) + "";

                if (s.equals("(") || s.equals("[")) {
                    stack.push(s);
                } else if (s.equals(")") || s.equals("]")) {
                    if (stack.empty()) {
                        isSafe = false;
                        break;
                    }

                    if (s.equals(")") && !stack.peek().equals("(") ||
                    s.equals("]") && !stack.peek().equals("[")) {
                        isSafe = false;
                        break;
                    }

                    stack.pop();
                 }
            }

            if (isSafe && stack.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
