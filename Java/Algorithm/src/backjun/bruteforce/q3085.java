package backjun.bruteforce;

import java.util.Scanner;

public class q3085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();

       char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                board[i] = s.toCharArray();
        }
        int answer = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                char temp = board[y][x];
                //위

                if (y + 1 < n) {
                    board[y][x] = board[y + 1][x];
                    answer = Math.max(answer, check(x, y + 1, temp, board));
                }

                if (y - 1 >= 0) {
                    //아래
                    board[y][x] = board[y - 1][x];
                    answer = Math.max(answer, check(x, y - 1, temp, board));
                }
                //왼
                if (x - 1 >= 0) {
                    board[y][x] = board[y][x - 1];
                    answer = Math.max(answer, check(x - 1, y, temp, board));
                }

                if (x + 1 < n) {
                    //우
                    board[y][x] = board[y][x + 1];
                    answer = Math.max(answer, check(x + 1, y, temp, board));
                }

                board[y][x] = temp;
            }
        }

        System.out.println(answer);
    }

    public static int check(int initX, int initY, char newValue, char[][] board) {

        int answer = 0;
        int count = 0;

        //위로

        for (int y = initY - 1; y >= 0; y--) {
            if (board[y][initX] != newValue) {
                break;
            }
            count++;
        }

        answer = Math.max(answer, count);

        //아래로

        for (int y = initY + 1; y < board.length; y++) {
            if (board[y][initX] != newValue) {
                break;
            }
            count++;
        }

        answer = Math.max(answer, count);
        count = 0;


        //왼쪽

        for (int x = initX - 1; x >= 0; x--) {
            if (board[initY][x] != newValue) {
                break;
            }
            count++;
        }
        answer = Math.max(answer, count);


        //오른쪽
        for (int x = initX + 1; x < board.length; x++) {
            if (board[initY][x] != newValue) {
                break;
            }
            count++;
        }
        answer = Math.max(answer, count);

        return answer + 1;
    }
}
