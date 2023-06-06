package backjun.dynamic;

import java.util.HashMap;
import java.util.Scanner;

public class q2748 {
    static HashMap<Integer,Long> hashMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(getFibonacci(n));
    }

    public static Long getFibonacci(int n) {
        if (n <= 0) {
            return  0L;
        }
        else if (n == 1) {
            return 1L;
        }
        else if (hashMap.get(n) != null) {
            return hashMap.get(n);
        }

        Long fibonacci = getFibonacci(n - 1) + getFibonacci(n - 2);
        hashMap.put(n, fibonacci);
        return fibonacci;
    }
}
