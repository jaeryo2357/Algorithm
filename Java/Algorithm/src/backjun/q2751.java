package backjun;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class q2751 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder answer = new StringBuilder();
        int n = scanner.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            integers.add(scanner.nextInt());
        }

        Collections.sort(integers);

        for (int i = 0; i < n; i++) {
            answer.append("" + integers.get(i) + "\n");
        }

        System.out.println(answer.toString());
    }
}
