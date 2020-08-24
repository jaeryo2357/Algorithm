package backjun.dynamic;

import java.util.Scanner;

public class q1932 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int length = (n * (2 + (n - 1))) / 2;
        int[] value = new int[length];
        int[] saveValue = new int[length];

        for (int index = 0; index < value.length; index++) {
            value[index] = scanner.nextInt();
            saveValue[index] = -1;
        }

        System.out.println( maxDfs(0, 0, value, saveValue));
    }

    public static int maxDfs(int deep, int index, int[] value, int[] saveValue) {
        if (index + (deep + 1) >= value.length) {
            return value[index];
        }

        int max = Integer.MIN_VALUE;

        for (int tree = 1; tree <= 2; tree++) {
            int treeIndex = index + (deep + tree);
            int temp = saveValue[treeIndex];
            if (temp == -1) {
                temp = maxDfs(deep + 1, treeIndex, value, saveValue);
                saveValue[treeIndex] = temp;
            }

            if (max < value[index] + temp) {
                max = value[index] + temp;
            }
        }

        return max;
    }
}
