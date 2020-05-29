package backjun;

import java.util.Scanner;
import java.util.HashSet;

public class q3052 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> num = new HashSet<>();

        for (int t = 0; t < 10; t++) {
            int n = scanner.nextInt();
            num.add(n % 42);
        }

        System.out.println(num.size());
    }
}
