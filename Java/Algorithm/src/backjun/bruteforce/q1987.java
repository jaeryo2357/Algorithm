package backjun.bruteforce;

import java.util.HashMap;
import java.util.Scanner;

public class q1987 {
    public static final int[] move = new int[] {0, 0, 1, -1};
    public static HashMap<Character, Boolean> hashmap = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();

        char[][] board = new char[r][c];

        for (int i = 0; i < r; i++) {
            board[i] = scanner.next().toCharArray();
        }

        hashmap.put(board[0][0], true);

        int answer = startBacktracking(0, 0, board);

        System.out.println(answer + 1);
    }

    public static int startBacktracking(int positionY, int positionX,
                                        char[][] board) {
        int maxMoveCount = 0;

        for (int i = 0; i < 4; i++) {
            int nextY = positionY + move[3 - i];
            int nextX = positionX + move[i];

            if (nextY >= 0 && nextY < board.length
                    && nextX >= 0 && nextX < board[nextY].length) {

                if (hashmap.get(board[nextY][nextX]) == null) {
                    hashmap.put(board[nextY][nextX], true);
                    maxMoveCount = Math.max(maxMoveCount, startBacktracking(nextY, nextX, board) + 1);
                    hashmap.remove(board[nextY][nextX]);
                }
            }
        }

        return maxMoveCount;
    }
}
