package backjun;

import java.util.Scanner;

public class q14889 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] score = new int[n][n];
        boolean[] person = new boolean[n]; //기본값 false link 팀

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score[i][j] = scanner.nextInt();
            }
        }

        System.out.println(findMinTeamValue(0, 0, score, person));

    }

    public static int findMinTeamValue(int dex, int pos, int[][] score, boolean[] person) {
        if (dex == person.length / 2) {
            //두팀의 차이 비교 return
            return getDistanceScoreTeam(score, person);
        }
        int min = Integer.MAX_VALUE;
        for (int index = pos; index < person.length; index++ ) {
            person[index] = true;
            int temp = findMinTeamValue(dex + 1, index + 1, score, person);
            if (min == -1 || min > temp) min = temp;
            if (min == 0) return min;

            person[index] = false;
        }

        return min;
    }

    public static int getDistanceScoreTeam(int[][] score, boolean[] person) {
        int sumStart = 0;
        int sumLink = 0;

        for (int i = 0; i < person.length; i++) {
            for (int j = 0; j < person.length; j++) {
                if (i != j && person[i] == person[j]) {
                    if (person[i]) { //start 팀
                        sumStart += score[i][j];
                    } else { //link 팀
                        sumLink += score[i][j];
                    }
                }
            }
        }

        return Math.abs(sumStart - sumLink);
    }
}
