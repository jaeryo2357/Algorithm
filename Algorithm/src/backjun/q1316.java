package backjun;

import java.util.Scanner;

public class q1316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int result = 0;

        for (int t = 0 ; t < n; t++) {
            String word = scanner.nextLine();
            boolean groupWord = true;
            for (int wordIndex = 0; wordIndex < word.length();) {
                char checking = word.charAt(wordIndex);

                while (checking == word.charAt(wordIndex)) {
                    word = word.substring(0, wordIndex) + word.substring(wordIndex + 1);
                    if (word.length() == 0) {
                        break;
                    }
                }
                if (word.contains(checking + "")) {
                    groupWord = false;
                }
            }
            if (groupWord) {
                result++;
            }
        }
        System.out.println(result);
    }
}
