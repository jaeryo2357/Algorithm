package other.programmer.m10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class p4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("baby"));
    }

    static class Solution {

        public long solution(String s) {

            if (isSame(s)) {
                return 0;
            }

            return pairScore(s);
        }

        public long pairScore(String s) {

            long answer = 0;
            for(int i = 0; i < s.length(); i++) {

                for (int j = i + 1; j < s.length(); j++) {
                    answer += score(s.substring(i, j + 1));
                }
            }

            return answer;
        }

        public boolean isSame(String s) {
            char target = s.charAt(0);

            for (int i = 1; i < s.length(); i++) {
                if (target == s.charAt(i)) {
                    return false;
                }
            }

            return true;
        }

        public long score(String s) {
            char[] chars = s.toCharArray();
            ArrayList<String> index = new ArrayList<>();

            for (int i = 0; i < chars.length; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (i != j) {
                        index.add("" + i + j);
                    }
                }
            }

            Collections.sort(index, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2.charAt(1) - o2.charAt(0)) - (o1.charAt(1) - o1.charAt(0));
                }
            });

            for (String indexPair : index) {
                if (chars[indexPair.charAt(0) - '0'] != chars[indexPair.charAt(1) - '0']) {
                    return indexPair.charAt(1) - indexPair.charAt(0);
                }
            }

            return 0;
        }
    }
}
