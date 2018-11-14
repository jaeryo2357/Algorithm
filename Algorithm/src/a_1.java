import java.util.Scanner;

public class a_1 {

	// 완전 비효율
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int check_NUM;

		Scanner scanner = new Scanner(System.in);
		check_NUM = scanner.nextInt();

		long start = System.currentTimeMillis();

		check_NUM = nextBigNumber(check_NUM);
		System.out.print(check_NUM);
		long end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (double) (end - start) / 1000.0 + "초");

	}

	public static int nextBigNumber(int check) {

		int onecount = 0;
		String s = Integer.toBinaryString(check);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				onecount++;
		}

		for (int i = check + 1; i < 1000000; i++) {
			int nextcheck = 0;
			s = Integer.toBinaryString(i);

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1')
					nextcheck++;
			}

			if (nextcheck == onecount)
				return i;
		}

		return -1;

	}
}
