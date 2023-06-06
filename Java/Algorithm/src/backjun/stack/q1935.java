package backjun.stack;

import java.util.Scanner;
import java.util.Stack;

public class q1935 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();

        int[] p = new int[n];

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }

        for (int i = 0; i < s.length(); i++) {

            char temp = s.charAt(i);

            if (temp <= 'Z' && temp >= 'A') {
                stack.push((double)p[temp - 'A']);
            } else {
                double o2 = stack.pop();
                double o1 = stack.pop();

                stack.push(calculate(o1, o2, temp));
            }
        }

        System.out.printf("%.2f", stack.pop());
    }

    public static double calculate(double o1, double o2, char action) {
        if (action == '+') {
            return o1 + o2;
        } else if (action == '-') {
            return o1 - o2;
        } else if (action == '*') {
            return o1 * o2;
        } else {
            return o1 / o2;
        }
    }
}
