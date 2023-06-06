package backjun;

import java.util.Scanner;

public class q1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y;
		Scanner scanner =new Scanner(System.in);
		x=scanner.nextInt();
		y=scanner.nextInt();
		
		int sum=0;
		
		for(int i=1;i<x;i++)
		{
			if(i==4||i==6||i==9||i==11)
				sum+=30;
			else if(i==2)
				sum+=28;
			else
				sum+=31;
		}
		
		sum += y-1;
		String result="";
		switch(sum%7)
		{
		case 0:
			result="MON";
			break;
		case 1:
			result="TUE";
			break;
		case 2:
			result="WED";
			break;
		case 3:
			result="THU";
			break;
		case 4:
			result="FRI";
			break;
		case 5:
			result="SAT";
			break;
		case 6:
			result="SUN";
			break;
			
		}
		
		System.out.print(result);
	}

}
