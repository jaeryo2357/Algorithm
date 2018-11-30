package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class q10817 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int[] num=new int[3];
		
		for(int i=0;i<3;i++)
		{
			num[i]=scanner.nextInt();
		}
		
		Arrays.sort(num);
		System.out.println(num[1]);
	}

}
