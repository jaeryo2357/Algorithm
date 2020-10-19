package other.programmer.m9;


public class p3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{9, -1, -5};
        System.out.println(solution.solution(arr));
    }

    static class Solution {

        public int solution(int[] a) {

            int answer = 0;
            int[] rightMinArray = new int[a.length + 1];
            for (int i = 0; i < rightMinArray.length; i++) {
                rightMinArray[i] = Integer.MAX_VALUE;
            }

            for (int i = a.length - 1; i >= 0 ; i--) {
                rightMinArray[i] = Math.min(rightMinArray[i + 1], a[i]);
            }

            int leftMin = a[0];
            for (int i = 1; i < a.length - 1; i++) {

                leftMin = Math.min(leftMin, a[i - 1]);

                if (!(leftMin < a[i] && rightMinArray[i] < a[i])) {
                    answer++;
                }
            }


            return answer + Math.min(2, a.length);
        }
    }
}
