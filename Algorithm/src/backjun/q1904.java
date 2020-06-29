package backjun;

import java.util.Scanner;

/**
 *  동적계획법을 재귀호출 없이 Bottom Up으로 반복문 형식으로 구현가능
 *
 */

public class q1904 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] saveCount = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                saveCount[i] = 1;
            } else if (i == 2) {
                saveCount[i] = 2;
            } else {
                saveCount[i] = (saveCount[i - 2] + saveCount[i - 1]) % 15746;
            }
        }

        System.out.println(saveCount[n]);
    }
}
