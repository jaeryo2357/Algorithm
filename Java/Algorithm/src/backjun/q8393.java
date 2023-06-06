package backjun;

import java.util.Scanner;

public class q8393 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		int sum=0;
		for(int i=1;i<=n;i++)
		{
			sum+=i;
		}
		System.out.println(sum);
	}

}
