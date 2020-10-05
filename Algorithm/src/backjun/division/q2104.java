package backjun.division;

import java.util.Scanner;

public class q2104 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(division(0, n - 1, arr));
    }

    public static long division(int start, int end, long[] arr) {
        if (start > end) return -1;
        else if (start == end) return arr[start] * arr[start];
        else {
            int mid = (start + end) / 2;
            long result = Math.max(division(mid + 1, end, arr), division(start, mid - 1, arr));

            long sum = arr[mid];
            long min = arr[mid];
            int l = mid, r = mid;

            while(r - l < end - start) {

                long lValue = l > start ? arr[l - 1] : -1;
                long rValue = r < end ? arr[r + 1] : -1;

                if (lValue > rValue) {
                    sum += lValue;
                    min = Math.min(min, lValue);
                    l--;
                } else {

                    sum += rValue;
                    min = Math.min(min, rValue);
                    r++;
                }

                result = Math.max(result, sum * min);
            }

            return result;
        }
    }
}
