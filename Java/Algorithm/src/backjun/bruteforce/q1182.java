package backjun.bruteforce;

import java.util.Scanner;

public class q1182 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();

        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        brute(s, 0, 0, num);
        if (s == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    public static void  brute(int target, int startIndex, int sum, int[] num) {
       if (startIndex >= num.length) {
            if (sum == target) {
                answer++;
            }
        } else {

            brute(target, startIndex + 1,sum, num);
            brute(target, startIndex + 1,sum + num[startIndex], num);

        }
    }
}
