package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q2178 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int m = scanner.nextInt();

        scanner.nextLine();

        char[][] board = new char[n][m];

        LinkedList<Pair<Integer, Integer>> currentQueue = new LinkedList<>();
        LinkedList<Pair<Integer, Integer>> nextQueue = new LinkedList<>();

        currentQueue.addFirst(new Pair<>(0, 0));

        for (int i = 0; i < n; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }

        int answer = 0;
        while (currentQueue.size() != 0) {
            Pair<Integer, Integer> point = currentQueue.removeLast();

            if (point.getKey() == n - 1 && point.getValue() == m - 1) {
                break;
            } else {

                int[] index = new int[]{-1, 1, 0, 0};

                for (int i = 0; i < 4; i++) {
                    int nextHeight = point.getKey() + index[i];
                    int nextWidth = point.getValue() + index[3 - i];

                    if (nextHeight >= 0 && nextHeight < board.length &&
                            nextWidth >= 0 && nextWidth < board[nextHeight].length) {

                        if (nextHeight == n - 1 && nextWidth == m - 1) {
                            System.out.println(answer + 2);
                            return;
                        } else if (board[nextHeight][nextWidth] == '1') {
                            board[nextHeight][nextWidth] = '0';
                            nextQueue.addFirst(new Pair<>(nextHeight, nextWidth));
                        }
                    }
                }
            }

            if (currentQueue.size() == 0 && nextQueue.size() != 0) {
                answer++;
                currentQueue.addAll(nextQueue);
            }
        }

        System.out.println(answer + 2);
    }

    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
