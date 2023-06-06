package backjun;

import java.util.Scanner;

public class q10250 {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int t = scanner.nextInt();

        for(int index = 0; index < t; index++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int n = scanner.nextInt();

            int floorNum = n % h;
            String floor = floorNum == 0 ? h + "" : floorNum + "";
            int roomNum = (n / h);
            if (n % h != 0) roomNum++;
            String room = roomNum + "";
            if (roomNum < 10) {
                room = "0" + room;
            }

            System.out.println(floor + room);
        }
    }
}
