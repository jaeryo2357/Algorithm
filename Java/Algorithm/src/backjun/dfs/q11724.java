package backjun.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class q11724 {
    public static boolean[] visited;
    public static List<LinkedList<Integer>> nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        visited = new boolean[n];
        nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nodes.add(new LinkedList<>());
        }

        for (int i = 0 ; i < m; i++) {
            int v1 = scanner.nextInt() - 1;
            int v2 = scanner.nextInt() - 1;

            nodes.get(v1).push(v2);
            nodes.get(v2).push(v1);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int position) {
        visited[position] = true;

        for (int connectPosition : nodes.get(position)) {
            if (!visited[connectPosition]) {
                dfs(connectPosition);
            }
        }
    }
}
