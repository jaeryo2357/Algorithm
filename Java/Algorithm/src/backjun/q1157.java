package backjun;

import java.util.Scanner;

public class q1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int[] count = new int['Z' - 'A' + 1];
        //대문자로
        word = word.toUpperCase();

        for (int t = 0; t < word.length(); t++) {
            int index =  word.charAt(t) - 'A';
            count[index]++;
        }

        int max = -1;
        int maxIndex = -1;
        boolean duplicate = false;

        for (int t = 0; t < count.length; t++) {
            if (count[t] > max) {
                max = count[t];
                maxIndex = t;
                duplicate = false;
            } else if (count[t] == max) {
                duplicate = true;
            }
        }

        if (duplicate) {
            System.out.println("?");
        } else {
            char result = (char) ('A' + maxIndex);
            System.out.println(result + "");
        }
    }
}
