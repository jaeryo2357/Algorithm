package backjun;

import java.util.Scanner;

public class q1712 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt(); //고정 지출
        int b = scanner.nextInt(); // 한대당 인건비
        int c = scanner.nextInt(); //노트북 한대 판매 값;
        if (b >= c) {
            System.out.println(-1);
        } else {
           int result = a / (c - b) + 1;
           System.out.println(result);
        }
    }
}
