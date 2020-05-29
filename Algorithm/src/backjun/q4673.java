package backjun;

import java.util.ArrayList;

public class q4673 {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();

        for (int n = 1; n <= 10000; n++) {
            num.add(n);
        }

        for (int index = 0; index < num.size(); index++) {
            selfNumber(num, num.get(index));
        }

        for (int index = 0; index < num.size(); index++) {
            System.out.println(num.get(index));
        }
    }

    private static void selfNumber(ArrayList<Integer> num, int number) {
        if (number > 10000) {
            return;
        }

        Integer selfNum = number;

        while (number / 10 != 0) {
            int placeOfOne = number % 10;
            selfNum += placeOfOne;

            number = (number - placeOfOne) / 10;
        }

        selfNum += number % 10;

        if (num.contains(selfNum)) {
            num.remove(selfNum);
        }

        selfNumber(num, selfNum);
    }
}
