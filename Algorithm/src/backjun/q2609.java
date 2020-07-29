package backjun;

import java.util.Scanner;

public class q2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int min = Math.min(num1, num2);

        //최대 공약수
        for (int i = min; i >=1; i--) {
            if(num1 % i == 0 && num2 % i == 0) {
                System.out.println(i);
                break;
            }
        }

        int num = min;
        while(num / num1 >= 0 && num % num1 != 0 || num / num2 >= 0 && num % num2 != 0) {
            num += min;
        }
        System.out.println(num);
    }
}
