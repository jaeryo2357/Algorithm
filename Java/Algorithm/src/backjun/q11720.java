package backjun;

import java.util.Scanner;

public class q11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N;
		Scanner scanner=new Scanner(System.in);
		N=scanner.nextInt();
		scanner.nextLine();
		String n=scanner.nextLine();
		int sum=0;
		for(int i=0;i<n.length();i++)
		{
			sum+=Integer.parseInt(n.charAt(i)+"");
		}
		System.out.println(sum);
	}

}
