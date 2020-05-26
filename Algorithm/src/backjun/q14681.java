package backjun;

import java.util.Scanner;

public class q14681 {
    public static void main(String[] args) {
        //입력 12       출력 1
        //      9
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int result;
        if (x > 0) {  // 1 4
            if (y > 0 ) {
                result = 1;
            } else {
                result = 4;
            }
        } else {     // 2 3
            if (y > 0) {
                result = 2;
            } else {
                result = 3;
            }
        }

        System.out.println(result);
    }
}
