package backjun.bfs;

import java.util.LinkedList;
import java.util.Scanner;

public class q9019 {
    public static boolean[] visited;
    public static LinkedList<Action> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while(t > 0) {
            visited = new boolean[10000];
            queue.clear();

            int target = scanner.nextInt();
            int goal = scanner.nextInt();

            queue.addFirst(new Action(target, "", null));

            while(!queue.isEmpty()) {
                Action action = queue.removeLast();
                if (bfs(action, goal)) {
                    StringBuilder builder = new StringBuilder();
                    while (action.preAction != null) {
                        builder.insert(0, action.action);
                        action = action.preAction;
                    }
                    System.out.println(builder.toString());
                    break;
                }
            }
            t--;
        }
    }

    public static boolean bfs(Action action, int goal) {
        if (action.value == goal) {
            return true;
        }

        int intValue = action.value;

        int dValue = (intValue * 2) % 10000;

        if (!visited[dValue]) {
            visited[dValue] = true;
            queue.addFirst(new Action(dValue, "D", action));
        }

        int sValue = intValue - 1 < 0 ? 9999 : intValue - 1;
        if (!visited[sValue]) {
            visited[sValue] = true;
            queue.addFirst(new Action(sValue, "S",
                    action));
        }

        int lValue = (intValue % 1000) * 10 + intValue / 1000;
        if (!visited[lValue]) {
            visited[lValue] = true;
            queue.addFirst(new Action(lValue, "L",
                    action));
        }

        int rValue = (intValue % 10) * 1000 + intValue / 10;
        if (!visited[rValue]) {
            visited[rValue] = true;
            queue.addFirst(new Action(rValue, "R",
                    action));
        }

        return false;
    }


    static class Action {
        int value;
        String action;
        Action preAction;

        public Action(int value, String action, Action preAction) {
            this.value = value;
            this.action = action;
            this.preAction = preAction;
        }

    }
}

