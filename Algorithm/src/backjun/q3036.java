package backjun;

import java.util.Scanner;

public class q3036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int firstRing = scanner.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int tempFirstRing = firstRing;
            int indexRing = scanner.nextInt();
            int gcb = gcb(tempFirstRing, indexRing);

            while(gcb != 1) {
                indexRing /= gcb;
                tempFirstRing /= gcb;
                gcb = gcb(tempFirstRing, indexRing);
            }
            System.out.println(tempFirstRing + "/" + indexRing);
        }
    }

    public static int gcb(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcb(b, a % b);
    }
}
