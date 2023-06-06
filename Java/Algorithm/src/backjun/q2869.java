package backjun;

import java.util.Scanner;

public class q2869 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); // 올라가는 거리
        int b = scanner.nextInt(); // 떨어지는 거리
        int v = scanner.nextInt(); //높이

        int result = (v - b - 1) / (a - b) + 1;
        System.out.println(result);
    }
}
