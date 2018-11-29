package backjun;

import java.util.Scanner;

public class q2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		Scanner scanner=new Scanner(System.in);
		
		N=scanner.nextInt();
		
		for(int i=1;i<=N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(i+j>=N)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
