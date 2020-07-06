package backjun;

import java.util.HashMap;
import java.util.Scanner;

public class q1463 {
    public static HashMap<Integer, Integer> saveValue = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(makeOneByMin(n));
    }

    public static int makeOneByMin(int n) {
        if (n == 1) {
            return 0;
        } else if (saveValue.get(n) != null) {
            return saveValue.get(n);
        } else {
            int min = Integer.MAX_VALUE;
            int tempValue;

            if (n % 3 == 0) {
                tempValue = 1 + makeOneByMin(n / 3);
                min = Math.min(min, tempValue);
            }
            if (n % 2 == 0) {
                tempValue = 1 + makeOneByMin(n / 2);
                min = Math.min(min, tempValue);
            }

            tempValue = 1 + makeOneByMin(n - 1);
            min = Math.min(min, tempValue);

            saveValue.put(n, min);
            return min;
        }
    }
}
