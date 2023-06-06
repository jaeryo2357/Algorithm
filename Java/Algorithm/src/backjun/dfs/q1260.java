package backjun.dfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class q1260 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt() - 1;

        Dfs dfs = new Dfs(n);

        for (int i = 0; i < m; i++) {
            int to = scanner.nextInt() - 1;
            int from = scanner.nextInt() - 1;

            dfs.addEdge(to, from);
            dfs.addEdge(from, to);
        }

        dfs.seach(v);

        System.out.println();

        Bfs bfs = new Bfs(n, dfs.nodes);

        bfs.search(v);

    }



    static class Dfs {

        int size;
        LinkedList<LinkedList<Integer>> nodes;
        boolean[] visit;

        Dfs(int size) {
            this.size = size;
            this.visit = new boolean[size];
            nodes = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                nodes.add(new LinkedList<>());
            }
        }

        public void addEdge(int to, int from) {
            nodes.get(to).add(from);
        }

        public void seach(int position) {
            if (size < position) {
                return;
            }
            visit[position] = true;
            System.out.print((position + 1) + " ");

            LinkedList<Integer> node = nodes.get(position);
            Collections.sort(node);

            for (Integer next : node) {
                if (!visit[next]) {
                    seach(next);
                }
            }
        }
    }

    static class Bfs {

        int size;
        LinkedList<LinkedList<Integer>> nodes;
        boolean[] visit;
        LinkedList<Integer> queue;

        Bfs(int size) {
            this.size = size;
            this.visit = new boolean[size];
            nodes = new LinkedList<>();
            queue = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                nodes.add(new LinkedList<>());
            }
        }

        Bfs(int size, LinkedList<LinkedList<Integer>> nodes) {
            this.size = size;
            this.nodes = nodes;
            this.visit = new boolean[size];
            queue = new LinkedList<>();
        }

        public void addEdge(int to, int from) {
            nodes.get(to).add(from);
        }

        public void search(int position) {
            if (size < position) {
                return;
            }
            visit[position] = true;
            System.out.print((position + 1)+ " ");
            LinkedList<Integer> node = nodes.get(position);
            Collections.sort(node);

            for (Integer next :  node) {
                if (!visit[next]) {
                    visit[next] = true;
                    System.out.print((next + 1) + " ");
                    queue.add(next);
                }
            }

            while (queue.size() > 0) {
                LinkedList<Integer> nextNode = nodes.get(queue.poll());
                Collections.sort(nextNode);

                for (Integer next :  nextNode) {
                    if (!visit[next]) {
                        visit[next] = true;
                        System.out.print((next + 1) + " ");
                        queue.add(next);
                    }
                }
            }

        }
    }
}
