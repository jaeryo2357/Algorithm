package other.programmer.m11;

import java.util.Arrays;

public class p1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("01110")));
    }

    static class Solution {

        public int[] solution(String s) {
            int[] answer = new int[2];

            while(!s.equals("1")) {
                int length = s.length();
                s = s.replaceAll("0", "");
                answer[1] += length - s.length();
                StringBuilder builder = new StringBuilder();
                int size = s.length();
                while(size > 0) {
                    builder.append(size % 2);
                    size /= 2;
                }

                s = builder.toString();

                answer[0]++;
            }
            return answer;
        }
    }
}
