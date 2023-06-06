package backjun;

import java.util.Scanner;

public class q1978 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;

        for (int t = 0; t < n; t++) {
            boolean isPrime = true;
            int number = scanner.nextInt();
            if (number != 1){
                for (int i = 2; i < number; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
