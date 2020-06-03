package backjun;

import java.util.Scanner;

public class q1002 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {

            int[][] circle = new int[2][2];
            int radius1, radius2;
            circle[0][0] = scanner.nextInt();  //첫번째 원 좌표
            circle[0][1] = scanner.nextInt();

            radius1 = scanner.nextInt();

            circle[1][0] = scanner.nextInt(); //두번째 원 좌표
            circle[1][1] = scanner.nextInt();

            radius2 = scanner.nextInt();

            double distance_pow = Math.pow((double)circle[1][0] - circle[0][0], 2) + Math.pow((double)circle[1][1] - circle[0][1], 2);
            double  distance = Math.sqrt(distance_pow);

            int min = Math.abs(radius1 - radius2);

            //두 원의 중점이 같은 경우
            if (circle[1][0] == circle[0][0] && circle[1][1] == circle[0][1]) {
                if (radius1 == radius2) {
                    System.out.println(-1);
                } else {
                    System.out.println(1);
                }
            } else {
                if (min < distance && distance < radius1 + radius2) {
                    System.out.println(2);
                } else if (min == distance || distance == radius1 + radius2) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            t--;
        }
    }
}
