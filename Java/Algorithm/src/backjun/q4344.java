package backjun;

import java.util.Scanner;

public class q4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int C;
		Scanner scanner=new Scanner(System.in);
		C=scanner.nextInt();
		
		for(int i=0;i<C;i++)
		{
			int N=scanner.nextInt();
			double average=0;
			int Count=0;
			double[] a=new double[N];
			for(int j=0;j<N;j++)
			{
				a[j]=scanner.nextDouble();
				average+=a[j];
			}
			
			average/=N;
			for(int j=0;j<N;j++)
			{
				if(a[j]>average)
					Count++;
			}
			System.out.printf("%.3f%s\n",(Count/(double)N)*100,"%");
		}
	}

}
