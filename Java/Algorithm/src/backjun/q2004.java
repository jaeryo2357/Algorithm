package backjun;

import java.util.Scanner;

public class q2004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long k = n - m;

        long nFiveCount = getCount(n, 5);
        long mFiveCount = getCount(m, 5);
        long kFiveCount = getCount(k, 5);

        long nTwoCount = getCount(n, 2);
        long mTwoCount = getCount(m, 2);
        long kTwoCount = getCount(k, 2);


        long allFiveCount = nFiveCount - (mFiveCount + kFiveCount);
        long allTwoCount = nTwoCount - (mTwoCount + kTwoCount);

        System.out.println(Math.min(allFiveCount, allTwoCount));

    }

    public static long getCount(long n, long division) {
        long count = 0;
        while(n > 0) {
            count += n / division;
            n /= division;
        }

        return count;
    }
}
