package backjun;

import java.util.Scanner;

public class q8958 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); //버퍼 지우기

        for (int t = 0; t < T; t++) {
            String exam = scanner.nextLine();
            int result = 0;
            int count = 0;

            for (int index = 0; index < exam.length(); index++) {
                if (exam.charAt(index) == 'O') {
                    count ++;
                    result += count;
                } else {
                    count = 0;
                }
            }

            System.out.println(result);
        }
    }
}
