package backjun.bruteforce;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class q1759 {
    public static String[] alphabet;
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int c = scanner.nextInt();

        alphabet = new String[c];
        for (int i = 0; i < c; i++) {
            alphabet[i] = scanner.next();
        }

        Arrays.sort(alphabet);

        dfs(0, "", l);

        writer.close();
    }

    public static void dfs(int position, String word, int l) throws IOException {
        if (word.length() == l && isCorrectWord(word)) {
            writer.write(word + "\n");
        }

        for (int i = position; i < alphabet.length; i++) {
            dfs(i + 1, word + alphabet[i], l);
        }
    }

    public static boolean isCorrectWord(String word) {
        int vowelCount = 0;
        int consonantCount = 0;
        //(a, e, i, o, u)
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        if (vowelCount >= 1 && consonantCount >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
