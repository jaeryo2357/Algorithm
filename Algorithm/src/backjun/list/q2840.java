package backjun.list;

import java.util.Arrays;
import java.util.Scanner;

public class q2840 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] saveValue = new int['Z' - 'A' + 1];

        Arrays.fill(saveValue, -1);

        char[] board = new char[n];

        Arrays.fill(board, '?');
        int position = 0;
        for (int i = 0; i < k; i++) {
            int step = scanner.nextInt() % n;

            position -= step;
            if (position < 0) position += n;

            char value = scanner.next().charAt(0);

            if (board[position] != '?' && board[position] != value) {
                System.out.println("!");
                return;
            } else if (board[position] == '?'){
                if (saveValue[value - 'A'] != -1) {
                    System.out.println("!");
                    return;
                }
                board[position] = value;
                saveValue[value - 'A'] = 1;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int nextPosition = (position + i) % n;

            char value = board[nextPosition];

            builder.append(value);
        }

        System.out.println(builder.toString());
    }
}
