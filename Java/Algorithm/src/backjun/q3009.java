package backjun;

import java.util.Scanner;
import java.util.ArrayList;

public class q3009 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int t = 0; t < 3; t++) {
            Integer x = scanner.nextInt();
            if (!xList.contains(x)) {
                xList.add(x);
            } else {
                xList.remove(x);
            }

            Integer y = scanner.nextInt();
            if (!yList.contains(y)) {
                yList.add(y);
            } else {
                yList.remove(y);
            }
        }

        System.out.printf("%d %d", xList.get(0), yList.get(0));

    }
}
