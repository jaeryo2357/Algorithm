package backjun.bfs;

import java.util.*;

public class q1525 {

    public static int[] move = new int[] {0, 0, 1, -1};
    public static ArrayList<Integer> goal = new ArrayList<>();
    public static HashSet<ArrayList<Integer>> visited = new HashSet<>();
    public static LinkedList<ArrayList<Integer>> linkedList = new LinkedList<>();
    public static LinkedList<ArrayList<Integer>> tempLinkedList = new LinkedList<>();

    public static void main(String[] args) {

        goal.add(1);
        goal.add(2);
        goal.add(3);
        goal.add(4);
        goal.add(5);
        goal.add(6);
        goal.add(7);
        goal.add(8);
        goal.add(0);

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> board = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            board.add(scanner.nextInt());
        }

        visited.add(board);
        linkedList.addFirst(board);

        boolean isAvailable = false;
        int time = 0;

        while(!linkedList.isEmpty()) {
            isAvailable = bfs(linkedList.removeLast());

            if (isAvailable) {
                break;
            }

            if (linkedList.isEmpty() && !tempLinkedList.isEmpty()) {
                time++;
                linkedList.addAll(tempLinkedList);
                tempLinkedList.clear();
            }
        }

        if (isAvailable) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean bfs(ArrayList<Integer> puzzle) {

        if (puzzle.equals(goal)) {
            return true;
        }

        for (int i = 0; i < puzzle.size(); i++) {
                if (puzzle.get(i) == 0) {

                    for (int k = 0; k < 4; k++) {
                        ArrayList<Integer> newPuzzle = new ArrayList<>(puzzle);

                        int newHeight = i / 3 + move[3 - k];
                        int newWidth = i % 3 + move[k];

                        if (newHeight >= 0 && newHeight < 3 && newWidth >= 0 && newWidth < 3) {
                            int swap = newPuzzle.get(newHeight * 3 + newWidth);
                            int value = newPuzzle.get(i);
                            newPuzzle.remove(newHeight * 3 + newWidth);
                            newPuzzle.add(newHeight * 3 + newWidth, value);

                            newPuzzle.remove(i);
                            newPuzzle.add(i, swap);

                            if (!visited.contains(newPuzzle)) {
                                visited.add(newPuzzle);
                                tempLinkedList.addFirst(newPuzzle);
                            }
                        }

                    }

                    return false;
                }
        }

        return false;
    }
}
