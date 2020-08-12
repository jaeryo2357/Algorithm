package backjun;

import java.util.Scanner;
import java.util.Stack;

public class q10828 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] runs = scanner.nextLine().split(" ");

            //PUSH
            if (runs.length > 1) {
                int num = Integer.parseInt(runs[1]);
                stack.push(num);
            } else {
                String printString;
                if (runs[0].equals("top")) {
                    int topValue = stack.empty() ? -1 : stack.peek();
                    printString = topValue + "";
                } else if (runs[0].equals("size")) {
                    printString = stack.size() + "";
                } else if (runs[0].equals("empty")) {
                    int emptyValue = stack.empty() ? 1 : 0;
                    printString = emptyValue + "";
                } else {
                    int popValue = stack.empty() ? -1 : stack.pop();
                    printString = popValue + "";
                }

                System.out.println(printString);
            }
        }
    }
}
