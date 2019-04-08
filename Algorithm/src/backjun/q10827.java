package backjun;

import java.math.BigDecimal;
import java.util.Scanner;

public class q10827 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		
		
		String a=scanner.next();
		int b=scanner.nextInt();
		String[] strings=a.split("\\.");
		int num=0;
		if(strings.length>1)
		  num=strings[1].length();
	
		
		long result=1;
		for(int i=0;i<b;i++)
		{
			result *= Integer.parseInt(strings[0]+strings[1]);
		}
		
		//result /= Math.pow(10, num);
		
		System.out.println(result);
		scanner.close();
	}
}
