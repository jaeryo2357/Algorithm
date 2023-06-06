package backjun.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class q11403 {
    public static ArrayList<LinkedList<Integer>> nodes;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        nodes = new ArrayList<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            LinkedList<Integer> node = new LinkedList<>();
            nodes.add(node);

            for (int j = 0; j < n; j++) {
                int line = scanner.nextInt();

                if (line == 1) {
                    node.add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[n];

                if (dfs(i, j)) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static boolean dfs(int start, int end) {
        if (visited[end]) {
            return true;
        }

        LinkedList<Integer> node = nodes.get(start);

        for (Integer connectNode : node) {
            if (!visited[connectNode]) {
                visited[connectNode] = true;
                boolean result = dfs(connectNode, end);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }
}
