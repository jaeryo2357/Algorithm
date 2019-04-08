package backjun;

import java.util.Scanner;

public class q10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int X = scanner.nextInt();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < N; i++) {

			
			
			int c = scanner.nextInt();
			if (c < X) {
				if (i >= 1&&!(s.length()==0))
					s.append(" ");
				s.append(c);
			
				
			}

		}
		System.out.println(s.toString());
		scanner.close();
	}

}
