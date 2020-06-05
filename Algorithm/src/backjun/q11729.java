package backjun;

import java.util.Scanner;

public class q11729 {

    private static StringBuilder result = new StringBuilder();
    private static int moveCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        hanoi(n, 1, 2, 3);
        System.out.println(moveCount + "\n" + result.toString());
    }

    public static void hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            result.append(from + " " + to + "\n");
            moveCount++;
            return;
        }

        hanoi(n - 1, from, to, by);

        result.append(from + " " + to + "\n");
        moveCount++;

        hanoi(n - 1, by, from, to);

    }
}
