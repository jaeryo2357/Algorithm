package backjun.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class q1700 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] useSequence = new int[k];

        for (int i = 0; i < useSequence.length; i++) {
            useSequence[i] = scanner.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();

        int answer = 0;
        for (int i = 0; i < useSequence.length; i++) {
            if (!list.contains(useSequence[i])) {
                if (list.size() == n) {
                    Integer removeSequence = null;
                    int maxAfterUse = 0;
                    for (int j = 0; j < list.size(); j++) {
                        int afterUse = useSequence.length + 1;
                        for (int t = i + 1; t < useSequence.length; t++) {
                            if (useSequence[t] == list.get(j)) {
                                afterUse = t;
                                break;
                            }
                        }

                        if (maxAfterUse < afterUse) {
                            removeSequence = list.get(j);
                            maxAfterUse = afterUse;
                        }
                    }

                    list.remove(removeSequence);
                    answer++;
                }
                list.add(useSequence[i]);
            }

        }

        System.out.println(answer);
    }
}
