package backjun.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9251 {
    static String firstWord = "";
    static String secondWord = "";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        firstWord = reader.readLine();
        secondWord = reader.readLine();

        int[][] saveLcs = new int[firstWord.length()][secondWord.length()];

        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 0; j < secondWord.length(); j++) {
                saveLcs[i][j] = -1;
            }
        }

        System.out.println(lcs(firstWord.length() - 1, secondWord.length() - 1, saveLcs));
    }

    public static int lcs(int firstLength, int secondLength, int[][] saveLcs) {
        if (firstLength < 0 || secondLength < 0) {
            return 0;
        } else if (saveLcs[firstLength][secondLength] != -1) {
            return saveLcs[firstLength][secondLength];
        } else {
            int max;

            if (firstWord.charAt(firstLength) == secondWord.charAt(secondLength)) {
                max = lcs(firstLength - 1, secondLength - 1, saveLcs) + 1;
            } else {
                max = Math.max(lcs(firstLength - 1, secondLength, saveLcs), lcs(firstLength, secondLength - 1, saveLcs));
            }

            saveLcs[firstLength][secondLength] = max;

            return max;
        }
    }
}
