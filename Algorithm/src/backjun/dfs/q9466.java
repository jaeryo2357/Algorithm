package backjun.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q9466 {
    public static int[] node;
    public static Set<Integer> teamNumber;
    public static boolean[] finished;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- != 0) {
            int n = scanner.nextInt();
            teamNumber = new HashSet<>();

            node = new int[n];
            finished = new boolean[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                node[i] = scanner.nextInt() - 1;
            }

            for (int i = 0; i < n; i++) {
                if (!finished[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - teamNumber.size());
        }
    }

    public static void dfs(int position) {
        if (visited[position] && finished[position]) {
            return;
        } else if (visited[position] && !finished[position]) {
            finished[position] = true;
            teamNumber.add(position);
            dfs(node[position]);
        } else {
            visited[position] = true;
            dfs(node[position]);
            finished[position] = true;
        }
    }
}
