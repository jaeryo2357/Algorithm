package backjun.greedy;

import java.util.*;

public class q11000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] room = new int[n][2];

        for (int i = 0; i < n; i++) {
            room[i][0] = scanner.nextInt();
            room[i][1] = scanner.nextInt();
        }

        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o1[0] - o2[0];
                if (result != 0) return result;
                else return o1[1] - o2[1];
            }
        });

        PriorityQueue<Integer> roomSize = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            if (!roomSize.isEmpty() && roomSize.peek() <= room[i][0]){
                roomSize.poll();
            }
            roomSize.add(room[i][1]);
        }

        System.out.println(roomSize.size());
    }
}
