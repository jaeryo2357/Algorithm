package backjun;

import java.util.Scanner;

public class q1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N;
		Scanner scanner=new Scanner(System.in);
		N=scanner.nextInt();
		
		int count=0;
		
		int result=N;
		while(true)
		{
			count++;
			result=cycle(result);
			if(result==N)
				break;
			
			
		}
		System.out.println(count);
		scanner.close();
	}
	public static int cycle(int num)
	{
	
		int result=num/10+num%10;
	
		return ((num%10)*10)+result%10;
	}
}
