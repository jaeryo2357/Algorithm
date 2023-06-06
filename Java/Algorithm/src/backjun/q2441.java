package backjun;

import java.util.Scanner;

public class q2441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N;
		Scanner scanner=new Scanner(System.in);
		
		N=scanner.nextInt();
		for(int i=N;i>0;i--)
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
