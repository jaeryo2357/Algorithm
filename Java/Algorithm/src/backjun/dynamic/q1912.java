package backjun.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] number = reader.readLine().split(" ");
        int[] saveMaxValue = new int[n];

        for (int index = 0; index < n; index++) {
            saveMaxValue[index] = Integer.parseInt(number[index]);
        }

        for (int index = 1; index < n; index++) {
            int value = saveMaxValue[index];
            saveMaxValue[index] = Math.max(value, value + saveMaxValue[index - 1]);
        }

        int result = Integer.MIN_VALUE;

        for (int index = 0; index < n; index++) {
            result = Math.max(result, saveMaxValue[index]);
        }

        System.out.println(result);
    }
}
