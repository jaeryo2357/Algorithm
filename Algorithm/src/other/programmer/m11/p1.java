package other.programmer.m11;

import java.util.*;

public class p1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] answer = solution.solution(4, true);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 3 5 6
    // 9 2 7
    // 4 1 8

    //
    static class Solution {

        public int[][] solution(int n, boolean horizontal) {

            int[][] answer = new int[n][n];

            int y = 0;
            int x = 0;

            boolean crossUp = !horizontal;
            if (horizontal) {
                x = 1;
            } else {
                y = 1;
            }

            int time = 1;
            while(x <= n - 1 || y <= n - 1) {

                answer[y][x] = time;

                if (x == n - 1 && y == n - 1) {
                    break;
                }

                if ((crossUp && (y - 1 < 0 || x + 1 >= n) ) || (!crossUp && (x - 1 < 0 || y + 1 >= n))) {
                    if (crossUp) {
                        if (x + 1 <= n - 1) {
                            x += 1;
                        } else {
                            y += 1;
                        }
                    } else {
                        if (y + 1 <= n - 1) {
                            y += 1;
                        } else {
                            x += 1;
                        }
                    }

                    time += 1;

                    crossUp = !crossUp;
                } else {
                    if (crossUp) {
                        x += 1;
                        y -= 1;
                    } else {
                        x -= 1;
                        y += 1;
                    }

                    time += 2;
                }
            }

            return answer;
        }
    }
}
