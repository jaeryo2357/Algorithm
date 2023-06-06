package backjun.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q10265 {
    public static int[] person = new int[1000];
    public static boolean[] visited = new boolean[1000];
    public static boolean[] finished = new boolean[1000];
    public static int[] availablePersonDp = new int[1000];
    public static Set<Integer> set = new HashSet<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        for (int i = 0; i < availablePersonDp.length; i++) {
            availablePersonDp[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            person[i] = scanner.nextInt() - 1;
        }

        int tempAnswer = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                set.clear();
                int needPerson = dfs(i);
                if (tempAnswer + needPerson <= k) {
                    tempAnswer += needPerson;
                } else if (needPerson <= k) {
                    tempAnswer = needPerson;
                } else if (tempAnswer + set.size() <= k) {
                    tempAnswer += set.size();
                } else if (set.size() <= k) {
                    tempAnswer = set.size();
                }

                answer = Math.max(answer, tempAnswer);
            }

        }

        System.out.println(answer);
    }

    public static int dfs(int position) {
        if (availablePersonDp[position] != -1) {
            return availablePersonDp[position];
        } else if (visited[position] && !finished[position]) {
            finished[position] = true;
            set.add(position);
            return dfs(person[position]);
        } else if (visited[position] && finished[position]) {
            return 0;
        } else {
            visited[position] = true;

            int needPerson = dfs(person[position]) + 1;

            if (finished[position]) {
                availablePersonDp[position] = set.size();
            } else {
                finished[position] = true;
                availablePersonDp[position] = needPerson;
            }

            return availablePersonDp[position];
        }
    }
}
