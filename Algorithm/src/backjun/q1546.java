package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class q1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N;
		Scanner scanner=new Scanner(System.in);
		N=scanner.nextInt();
		
		double[] Scroe=new double[N];
		
		for(int i=0;i<N;i++)
		{
			Scroe[i]=scanner.nextDouble();
		}
		
		Arrays.sort(Scroe);
		double result=0.0f;
		for(int i=0;i<Scroe.length;i++)
		{
			Scroe[i]=(Scroe[i]/Scroe[Scroe.length-1])*100;
			result+=Scroe[i];
		}
	
		System.out.printf("%f",result/N);
		scanner.close();
	}

}
