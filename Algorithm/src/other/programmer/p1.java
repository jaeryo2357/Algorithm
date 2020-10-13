package other.programmer;

public class p1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(45));
    }

    static class Solution {

        public int solution(int n) {
            int answer = 0;


            StringBuilder builder = new StringBuilder();

            while(n != 0) {

                builder.append("" + n % 3 );
                n /= 3;
            }
            String value = builder.toString();
            for (int i = value.length() - 1; i >= 0; i--) {

                answer += (value.charAt(i) - '0') * Math.pow(3, value.length() - 1 - i);
            }

            return answer;
        }
    }
}
