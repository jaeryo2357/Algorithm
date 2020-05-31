package backjun;

import java.util.Scanner;

public class q2275 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int index = 0; index < t; index++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[] room = new int[14];
            room[0] = 1;
            for (int floor = 0; floor <= k; floor++) {
                for (int roomIndex = 0; roomIndex < room.length - 1; roomIndex++) {
                    if (floor == 0) {
                        room[roomIndex + 1] = roomIndex + 2;
                    } else {
                        room[roomIndex + 1] += room[roomIndex];
                    }
                }
            }
            System.out.println(room[n - 1]);
        }
    }
}
