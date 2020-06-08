package backjun;

import java.util.Scanner;

public class q1436 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int answer = 0;
        int count = 0;
        int n = scanner.nextInt();

        for (int i = 0; i < n * 1000; i++) {
            String temp = "" + i;
            if (temp.contains("666")) {
                count++;
                if (count == n) {
                    answer = i;
                    break;
                }
            }
        }


        System.out.println(answer);
    }
}
