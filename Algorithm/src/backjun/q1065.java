package backjun;

import java.util.Scanner;

public class q1065 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;

        for (int t = 1; t <= n; t++) {
            if (hasSu(t)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean hasSu(int n) {
        Integer placeTemp = null;
        Integer distance = null;

        while (n / 10 != 0) {
            int placeOfOne = n % 10;

            if (placeTemp == null) {
                placeTemp = placeOfOne;
            } else if (distance == null) {
                distance = placeOfOne - placeTemp;
                placeTemp = placeOfOne;
            } else {
                if ( distance != placeOfOne - placeTemp) {
                    return false;
                } else {
                    placeTemp = placeOfOne;
                }
            }
            n = (n - placeOfOne) / 10;
        }

        if (distance != null && placeTemp != null && distance != (n % 10) - placeTemp) {
            return false;
        }

        return true;
    }
}
