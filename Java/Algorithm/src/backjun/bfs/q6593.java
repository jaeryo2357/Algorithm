package backjun.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class q6593 {
    public static int[] move = new int[] {0, 0, 1, -1};
    public static ArrayList<ArrayList<Character[]>> board = new ArrayList<>();
    public static ArrayList<ArrayList<Boolean[]>> visited = new ArrayList<>();
    public static LinkedList<Point> queue = new LinkedList<>();
    public static LinkedList<Point> tempQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            board.clear();
            visited.clear();
            queue.clear();
            tempQueue.clear();

            for (int i = 0; i < l; i++) {
                ArrayList<Character[]> tempBoard = new ArrayList<>();
                ArrayList<Boolean[]> tempVisited = new ArrayList<>();
                for (int h = 0; h < r; h++) {

                    char[] temp = scanner.next().toCharArray();
                    Character[] item = new Character[temp.length];

                    for (int j = 0; j < temp.length; j++) {
                        if (temp[j] == 'S') {
                            queue.addFirst(new Point(i, j, h));
                        }
                        item[j] = temp[j];
                    }
                    tempBoard.add(item);

                    Boolean[] visitedItem = new Boolean[temp.length];
                    for (int k = 0; k < visitedItem.length; k++) {
                        visitedItem[k] = false;
                    }
                    tempVisited.add(visitedItem);
                }

                board.add(tempBoard);
                visited.add(tempVisited);
            }

            boolean answer = false;
            int time = 0;
            while(queue.size() > 0) {
                Point nextPoint = queue.removeLast();
                answer = bfs(nextPoint.floor, nextPoint.y, nextPoint.x);
                if (answer) {
                    break;
                }

                if (queue.size() == 0 && tempQueue.size() > 0) {
                    queue.addAll(tempQueue);
                    tempQueue.clear();
                    time++;
                }
            }

            if (answer) {
                System.out.printf("Escaped in %d minute(s).\n", time);
            } else {
                System.out.println("Trapped!");
            }

        }
    }

    public static boolean bfs(int floor, int y, int x) {
        if (board.get(floor).get(y)[x] == 'E') {
            return true;
        }
        visited.get(floor).get(y)[x] = true;

        for (int i = 0; i < 4; i++) {
           if ( y + move[i] >= 0 && y + move[i] < board.get(floor).size()
                   && x + move[3 - i] >= 0 && x + move[3 - i] < board.get(floor).get(y).length
                   && !visited.get(floor).get(y + move[i])[x + move[3 - i]]
                   && board.get(floor).get(y + move[i])[x + move[3 - i]] != '#') {

               visited.get(floor).get(y + move[i])[x + move[3 - i]] = true;
               tempQueue.addFirst(new Point(floor, x + move[3 - i], y + move[i]));
           }
        }

        if (floor - 1 >= 0 && !visited.get(floor - 1).get(y)[x]
        && board.get(floor - 1).get(y)[x] != '#') {
            visited.get(floor - 1).get(y)[x] = true;
            tempQueue.addFirst(new Point(floor - 1, x, y));
        }

        if (floor + 1 < board.size() && !visited.get(floor + 1).get(y)[x]
                && board.get(floor + 1).get(y)[x] != '#') {
            visited.get(floor + 1).get(y)[x] = true;
            tempQueue.addFirst(new Point(floor + 1, x, y));
        }

        return false;
    }

    static class Point {
        int floor;
        int y;
        int x;

        public Point(int floor, int x, int y) {
            this.floor = floor;
            this.x = x;
            this.y = y;
        }
    }
}
