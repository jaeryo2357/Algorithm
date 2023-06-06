package backjun;

import java.util.Scanner;

public class q2588 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        for (int i = 0, count = 1 ; i < 3 ; i++,count *= 10) {
            int temp =num1 * ((num2 % (count * 10)) / (count));
            System.out.println(temp);
            result += temp * count;
        }
        System.out.println(result);
    }
}
