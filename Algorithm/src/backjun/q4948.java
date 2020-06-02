package backjun;

import java.util.Scanner;

public class q4948 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNum = scanner.nextInt();

        while(inputNum != 0) {
            System.out.println(sizePrime(inputNum));

            inputNum = scanner.nextInt();
        }
    }

    public static int sizePrime(int num) {
        boolean[] prime = new boolean[2 * num + 1]; //기본값 false
        int size = 0;
        for (int n = 2; n * n <= 2 * num; n++) {
            if (prime[n]) {
                continue;
            }
            for (int t = n + n; t <= 2 * num; t += n) {
                if (t % n == 0) {
                    prime[t] = true;
                }
            }
        }

        for (int i = num + 1; i <= 2 * num; i++) {
            if (!prime[i]) {
                size++;
            }
        }

        return size;
    }
}
