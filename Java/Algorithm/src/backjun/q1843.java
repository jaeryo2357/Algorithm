package backjun;

import java.util.ArrayList;
import java.util.Scanner;

public class q1843 {
	
	static ArrayList<Integer> prime=new ArrayList<>();

	public static void getPrime(int num) {

		prime.add(2); 
	
		for (int i = 2; i <= num; i++) {

			for (int j = 0; prime.size() > j; j++) {

				if (i % prime.get(j) == 0) break; // 소수가 아닌 경우 pass
				if (j + 1 == prime.size()) // 소수일 때
					prime.add(i);

			}

		}

		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		Scanner scanner=new Scanner(System.in);
		N=scanner.nextInt();
		
		System.out.println(NumA(N));
		
	}
	
	public static int NumA(int Q)
	{
		int sum=0;
		for(int i=3;i<=Q;i++) {
		if(i%2==0)
			sum+= i/2-1;
		else
			sum+= (int)i/2;
		}
		return sum;
	}
	
	public static int NumBC(int Q)
	{
		int sumB=0;
		
		for(int i:prime)
		{
			if(Q%(Q/i)==0)
			sumB+=1;
			else
			{
				if(Q%(Q/i)==0)
					sumB+=1;
			}
			
			
		}
		
		
		
		return 0;
	}
	


}
