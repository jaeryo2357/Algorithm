package backjun.binaryseach;

import java.util.Scanner;

public class q15732 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int d = scanner.nextInt();

        Rule[] rules = new Rule[k];

        for (int i = 0; i < k; i++) {
            int startIndex = scanner.nextInt();
            int endIndex = scanner.nextInt();
            int step = scanner.nextInt();

            rules[i] = new Rule(startIndex, endIndex, step);
        }

        int minBox = 1;
        int maxBox = n;

        while (minBox <= maxBox) {
            int middleBox = (minBox + maxBox) / 2;

            long tempD = 0;
            for (int i = 0; i < k; i++){
                Rule rule = rules[i];

                if (rule.endIndex > middleBox && rule.startIndex <= middleBox) {
                    tempD += (middleBox - rule.startIndex) / rule.step + 1;

                } else if (rule.endIndex <= middleBox) {
                    tempD += (rule.endIndex - rule.startIndex) / rule.step + 1;
                }
            }

            if (tempD < d) {
                minBox = middleBox + 1;
            } else {
                maxBox = middleBox - 1;
            }
        }

        System.out.println(minBox);
    }

    static class Rule {
        int startIndex;
        int endIndex;
        int step;

        public Rule(int startIndex, int endIndex, int step) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.step = step;
        }
    }
}
