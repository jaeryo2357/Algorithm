package backjun.division;

import java.util.Scanner;

public class q1074 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(division(n, 0, 0, c, r) - 1);
    }


    public static int division(int n, int startX, int startY, int targetX, int targetY) {
        if (n == 0 ) {
            return 1;
        } else {
            int count = 0;

            int length = (int)Math.pow(2, n);
            int step = length / 2;

            for (int y = startY; y < startY + length; y += step) {
                for (int x = startX; x < startX + length; x += step) {
                    if (y > targetY ) break;
                    else if (targetX >= x + step|| targetY >= y + step) {
                        count += (length * length) / 4;
                    } else if (targetX >= x && targetY >= y){
                        count += division(n - 1, x, y, targetX, targetY);
                    }
                }
            }

            return count;
        }
    }
}
