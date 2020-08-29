package backjun.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1708 {
    private static int[] answer = new int[]{0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        division(n, 0, 0, board);

        System.out.printf("%d\n%d\n%d", answer[0], answer[1], answer[2]);
    }

    public static void division(int n, int startX, int startY, int[][] board) {
        if (n == 0) {
            return;
        }

        int target = board[startY][startX];

        for (int h = startY; h < startY + n; h++) {
            for (int w = startX; w < startX + n; w++) {
                if (target != board[h][w]) {
                    int nextN = n / 3;
                    for (int nextH = startY; nextH < startY + n; nextH += nextN) {
                        for (int nextW = startX; nextW < startX + n; nextW += nextN) {
                            division(nextN, nextW, nextH, board);
                        }
                    }

                    return;
                }
            }
        }

        if (target == -1) {
            answer[0]++;
        } else if (target == 0) {
            answer[1]++;
        } else {
            answer[2]++;
        }
    }
}
