package backjun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class q15652 {
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        explore(n,1, m, "");

        writer.close();
    }

    public static void explore(int range, int start, int end, String answer) throws IOException {

        if (answer.length() >= end + end) {
            writer.write(answer.substring(1) + "\n");
            return;
        }

        for (int number = 1; number <= range; number++) {
            if (number >= start) {
                explore(range, number, end, answer + " " + number);
            }
        }
    }
}
