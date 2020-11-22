package backjun.stack;

import java.util.Scanner;
import java.util.Stack;

public class q1918 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (temp >= 'A' && temp <= 'Z') {
                System.out.print(temp);
            } else if (temp == '(' || temp == ')') {
                if (temp == '(') {
                    stack.push(temp);
                } else {
                    while ('(' != stack.peek()) {
                        System.out.print(stack.pop());
                    }
                    stack.pop();
                }
            } else {
                if ((temp == '+' || temp == '-')) {
                    while (!stack.empty() && (stack.peek() != '(')) {
                        System.out.print(stack.pop());
                    }
                } else if ((temp == '*' || temp == '/')) {
                    while (!stack.empty() && (stack.peek() != '(') && (stack.peek() != '+' && stack.peek() != '-')) {
                        System.out.print(stack.pop());
                    }
                }
                stack.push(temp);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}
