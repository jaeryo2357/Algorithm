package backjun;

import java.util.Scanner;
import java.util.Arrays;

public class q4513 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] triangle =  new int[3];

        while (true) {

            for (int t = 0; t < 3; t++) {
                triangle[t] = scanner.nextInt();
            }

            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) {
                break;
            }
            Arrays.sort(triangle);

            if (Math.pow(triangle[0], 2) + Math.pow(triangle[1],2 )
            == Math.pow(triangle[2], 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }

    }
}
