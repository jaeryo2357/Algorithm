package backjun;

import java.util.Scanner;
import java.util.Stack;

public class q10773 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        Stack<Integer> stack  = new Stack<>();

        for (int i = 0; i < k; i++) {
            int num = scanner.nextInt();
            if (num != 0) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }

        int answer = 0;
        for (int num : stack) {
            answer += num;
        }

        System.out.println(answer);
    }
}
