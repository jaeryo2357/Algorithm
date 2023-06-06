package backjun;

import java.util.Scanner;

public class q10039 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        for (int t = 0; t < 5; t++) {
            int exam = scanner.nextInt();
            if (exam < 40) {
                exam = 40;
            }
            result += exam;
        }
        System.out.println(result/5);
    }
}
