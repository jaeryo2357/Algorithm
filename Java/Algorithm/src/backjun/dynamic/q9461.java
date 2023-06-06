package backjun.dynamic;

import java.util.Scanner;

public class q9461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        long[] saveLength; //n에 따른 길이를 저장하는 배열
        for (int test = 0; test < t; test++) {
            int n = scanner.nextInt();
            saveLength = new long[n + 1];

            for (int index = 1; index <= n; index++) {
                if (index <= 3) {
                    saveLength[index] = 1;
                } else if (index <= 5) {
                    saveLength[index] = 2;
                } else {
                    saveLength[index] = saveLength[index - 1] + saveLength[index - 5];
                }
            }

            System.out.println(saveLength[n]);
        }
    }
}
