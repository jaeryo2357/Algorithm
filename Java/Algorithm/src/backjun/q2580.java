package backjun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class q2580 {

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        ArrayList<BlankPosition> blanks = new ArrayList<>();
        int[][] board = new int[9][9];

        for (int height = 0; height < 9; height++) {
            for (int width = 0; width < 9; width++) {
                int num = scanner.nextInt();

                if (num == 0) {
                    blanks.add( new BlankPosition(width, height));
                }

                board[height][width] = num;
            }
        }

        dfs(board, blanks, 0);

    }

    public static void dfs(int[][] board, ArrayList<BlankPosition> blankPosition, int index) throws IOException {
        if (index == blankPosition.size()) {
            print(board);
            System.exit(0);
        }

        for (int num = 1; num < 10; num++) {
            BlankPosition blank = blankPosition.get(index);
            if (widthCheck(board, blank, num) && heightCheck(board, blank, num) && squareCheck(board, blank, num)) {
                board[blank.height][blank.width] = num;
                dfs(board, blankPosition, index + 1);
                board[blank.height][blank.width] = 0;  // 안될경우
            }
        }
    }

    public static void print(int[][] board) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String temp;
        for (int i = 0; i < 9; i++) {
            temp = "";
            for (int j = 0; j < 9; j++) {
                temp += " " + board[i][j];
            }
            temp = temp.substring(1) + "\n";
            writer.write(temp);
        }

        writer.close();
    }

    public static boolean widthCheck(int[][] board, BlankPosition blank, int value) {
        for (int width = 0; width < 9; width++) {
            if (blank.width != width && board[blank.height][width] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean heightCheck(int[][] board, BlankPosition blank, int value) {
        for (int height = 0; height < 9; height++) {
            if (blank.height != height && board[height][blank.width] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean squareCheck(int[][] board, BlankPosition blank, int value) {
        int startWidth = 3 * (blank.width / 3);
        int startHeight = 3 * (blank.height / 3);

        for (int width = startWidth; width < startWidth + 3; width++) {
            for (int height = startHeight; height < startHeight + 3; height++) {
               if (board[height][width] == value && height != blank.height && width != blank.width) {
                   return false;
               }
            }
        }

        return true;
    }

    static class BlankPosition {
        int width;
        int height;

        BlankPosition(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
