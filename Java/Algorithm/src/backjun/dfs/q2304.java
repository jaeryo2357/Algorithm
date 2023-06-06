package backjun.dfs;

import java.util.Scanner;
import java.util.Stack;

public class q2304 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] heights = new int[1001];

        int left = 1000;
        int right = 0;
        int maxHeightIndex = 0;

        for (int i = 0; i < n; i++) {
            int index = scanner.nextInt();

            left = Math.min(left, index);
            right = Math.max(right, index);
            heights[index] = scanner.nextInt();

            maxHeightIndex = heights[index] > heights[maxHeightIndex] ? index : maxHeightIndex;
        }

        int result = heights[maxHeightIndex];

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = left; i < maxHeightIndex; i++) {
           if (heights[i] != 0) {

               if (stack.empty() || heights[stack.peek()] < heights[i]) {
                   stack.push(i);
               }
           }

           result += heights[stack.peek()];
        }

        stack.clear();

        for (int j = right; j > maxHeightIndex; j--) {
            if (heights[j] != 0) {

                if (stack.empty() || heights[stack.peek()] < heights[j]) {
                    stack.push(j);
                }
            }

            result += heights[stack.peek()];
        }

        System.out.println(result);
    }
}
