package backjun;

import java.util.Scanner;

public class q2884 {
    public static void main(String[] args) {
        //입력 10 10   출력 9 25
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int m = scanner.nextInt();

        int time = h * 60 + m - 45;

        if (time < 0) {
            time = 60 * 24 + time;
        }

        System.out.printf("%d %d",time / 60,time % 60);
    }
}
