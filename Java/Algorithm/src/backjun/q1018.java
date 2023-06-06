package backjun;

import java.util.Scanner;

public class q1018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int answer = n * m;

        scanner.nextLine();
        char[][] board = new char[n][m];

        for(int h = 0; h < board.length; h++) {
            String width = scanner.nextLine();
            for (int w = 0; w < board[h].length; w++) {
                board[h][w] = width.charAt(w);
            }
        }

        for(int h = 0; h <= board.length - 8; h++) {
            for (int w = 0; w <= board[h].length - 8; w++) {
                int result = checkBoard(board, w, h);
                if (answer > result) {
                    answer = result;
                }
            }
        }

        System.out.println(answer);
    }

    public static int checkBoard(char[][] board, int startW, int startH) {
        int result;

        char check = 'W';
        boolean match = true;
        int changeCount = 0;

        for(int h = 0; h < 8; h++) {
            for (int w = 0; w < 8; w++) {
                if ((check == board[startH + h][startW + w]) != match) {
                    changeCount++;
                }
                match = !match;
            }
            match = !match;
        }

        result = changeCount;

        check = 'B';
        match = true;
        changeCount = 0;

        for(int h = 0; h < 8; h++) {
            for (int w = 0; w < 8; w++) {
                if ((check == board[startH + h][startW + w]) != match) {
                    changeCount++;
                }
                match = !match;
            }
            match = !match;
        }

        if (result > changeCount) {
            result = changeCount;
        }

        return result;
    }
}
