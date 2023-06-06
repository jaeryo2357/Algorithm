package backjun;

import java.util.*;

public class q5622 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String dialog;
		Scanner scanner=new Scanner(System.in);
		int sum=0;
		dialog=scanner.next();
		
		
		for(int i=0;i<dialog.length();i++)
		{
			sum += getScore(dialog.charAt(i));
		}
		
		System.out.println(sum);
		
	}

	public static int getScore(char at)
	{
		
		switch(at)
		{
		case 'A':
		case 'B':
		case 'C':
			return 3;
		case 'D':
		case 'E':
		case 'F':
			return 4;
		case 'G':
		case 'H':
		case 'I':
			return 5;
		case 'J':
		case 'K':
		case 'L':
			return 6;
		case 'M':
		case 'N':
		case 'O':
			return 7;
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
			return 8;
		case 'T':
		case 'U':
		case 'V':
			return 9;
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			return 10;
			default :
				return 11;
		  
		
		}
	}
}
