package backjun.division;

import java.util.Scanner;

public class q2339 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int answer = division(0, n, 0, n, board, -1);
        System.out.println(answer == 0 ? -1 : answer);
    }

    /**
     *
     * @param direction 0 : 가로, 1 : 세로
     * @return
     */
    public static int division(int startX, int endX, int startY, int endY, int[][] board, int direction) {
        int starCount = 0;
        int impuritiesCount = 0;

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                if (board[y][x] == 2) {
                    starCount++;
                } else if (board[y][x] == 1) {
                    impuritiesCount++;
                }
            }
        }
        if (starCount == 0) return 0;
        else if (starCount == 1 && impuritiesCount == 0) return 1;

        int answer = 0;

        //불순물 위치를 저장하려 했으나 메모리 초과 발생
        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
              if (board[y][x] == 1) {
                  if (direction != 0) { //세로로 자르기 가능
                      answer += division(startX, x, startY, endY, board, 0) *
                              division(x + 1, endX, startY, endY, board, 0);
                  }
                  if (direction != 1) { //가로로 자르기 가능
                      answer += division(startX, endX, startY, y, board, 1) *
                              division(startX, endX, y + 1, endY, board, 1);
                  }
                }
            }
        }

        return answer;
    }
}
