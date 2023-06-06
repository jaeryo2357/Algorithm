package backjun.division;

import java.util.Scanner;

public class q1725 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }

        System.out.println(histogram(0, n - 1, h));
    }


    public static long histogram(int start, int end, int[] h) {
        if (start == end) return h[start];
        else if (start + 1 == end) return Math.min(h[start], h[end]) * 2;
        else {
            int mid = (start + end) / 2;
            long result = Math.max(histogram(start, mid, h), histogram(mid, end, h));

            int l = mid, r = mid;
            int height = h[mid];

            while(r - l < end - start) {
                int lValue = l > start ? h[l - 1] : -1;
                int rValue = r < end ? h[r + 1] : -1;

                if (lValue > rValue) {
                    height = Math.min(height, lValue);
                    l--;
                } else {
                    height = Math.min(height, rValue);
                    r++;
                }

                result = Math.max(result, (r - l + 1) * height);
            }
            return result;
        }
    }
}
