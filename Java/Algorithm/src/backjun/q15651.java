package backjun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class q15651 {
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> number = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();


        for (int i = 1; i <= n; i++) {
            number.add(i);
        }

        explore(m, number, "");

        writer.close();
    }

    public static void explore(int m, ArrayList<Integer> number, String answer) throws IOException {

        if (answer.length() >= m + m) {

           writer.write(answer.substring(1) + "\n");
            return;
        }

        for (int i = 0; i < number.size(); i++ ) {
            Integer num = number.get(i);
            explore(m, number, answer + " " + num);
        }
    }
}
