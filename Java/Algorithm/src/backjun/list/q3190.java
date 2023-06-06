package backjun.list;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class q3190 {
    static int snakeRow = 0;
    static int snakeCol = 0;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int k = scanner.nextInt();
        int direct = 0; // 0 : right, 90: top, 180: left, 270: bottom

        int[][] board = new int[n][n];

        LinkedList<Snake> snakes = new LinkedList<>();
        snakes.addFirst(new Snake(0, 0));

        for (int i = 0; i < k; i++) {
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            board[row][col]++;
        }

        int l = scanner.nextInt();
        int currentTime = 0;
        for (int i = 0; i < l; i++) {
            int nextTime = scanner.nextInt();
            int moveTime = nextTime - currentTime;
            for (int t = 0; t < moveTime; t++) {
                currentTime++;
                if (move(direct)) {
                    Snake newSnake = new Snake(snakeRow, snakeCol);
                    if (snakes.contains(newSnake)) {
                        System.out.println(currentTime);
                        return;
                    } else {
                        snakes.addLast(newSnake);
                    }
                } else {
                    System.out.println(currentTime);
                    return;
                }

                if (board[snakeRow][snakeCol] == 0) {
                    snakes.removeFirst();
                } else {
                    board[snakeRow][snakeCol]--;
                }
            }

            String nextDirection = scanner.next();

            if (nextDirection.equals("L")) {
                direct = (direct + 90) % 360;
            } else {
                direct -= 90;
                if (direct < 0) {
                    direct += 360;
                }
            }
        }

        while (move(direct)) {
            currentTime++;
            Snake newSnake = new Snake(snakeRow, snakeCol);
            if (snakes.contains(newSnake)) {
                currentTime--;
                break;
            } else {
                snakes.addLast(newSnake);
            }

            if (board[snakeRow][snakeCol] == 0) {
                snakes.removeFirst();
            } else {
                board[snakeRow][snakeCol]--;
            }
        }

        System.out.println(currentTime + 1);
    }

    public static boolean move(int direction) {
        if (direction == 0) {
            snakeCol++;
            if (snakeCol == n) {
                return false;
            }
        } else if (direction == 90) {
            snakeRow--;
            if (snakeRow < 0) {
                return false;
            }
        } else if (direction == 180) {
            snakeCol--;
            if (snakeCol < 0) {
                return false;
            }
        } else {
            snakeRow++;
            if (snakeRow == n) {
                return false;
            }
        }
        return true;
    }


    static class Snake {
        int row;
        int col;

        Snake(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Snake snake = (Snake) o;
            return row == snake.row &&
                    col == snake.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
