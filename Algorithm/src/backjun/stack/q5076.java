package backjun.stack;

import java.util.Scanner;
import java.util.Stack;

public class q5076 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        String line = "";
        while(!(line = scanner.nextLine()).equals("#")) {
            stack.clear();
            StringBuilder builder = new StringBuilder();
            boolean isWord = false;
            boolean isCloseTag = false;
            for (int i = 0; i < line.length(); i++) {
                char temp = line.charAt(i);

                if (temp == '<') {
                    isWord = true;
                } else if (isWord && temp == '>') {
                    isWord = false;
                    String word = builder.toString();
                    if (stack.isEmpty() || !stack.peek().startsWith(word) && !isCloseTag) {
                        stack.push(word);
                    } else if (!stack.isEmpty() && stack.peek().startsWith(word) && isCloseTag) {
                        stack.pop();
                    }
                    if (isCloseTag) {
                        isCloseTag = false;
                    }

                    builder = new StringBuilder();
                } else if (isWord && temp == '/') {
                    isCloseTag = true;
                } else if (isWord){
                    builder.append(temp);
                }
            }

            if (stack.size() == 0) {
                System.out.println("legal");
            } else {
                System.out.println("illegal");
            }
        }
    }
}
