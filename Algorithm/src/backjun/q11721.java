package backjun;

import java.util.Scanner;

public class q11721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s;
		Scanner scanner =new Scanner(System.in);
		s=scanner.nextLine();
		
		for(int i=0;;i++)
		{
			if((i*10+10)<s.length())
			System.out.println(s.substring(i*10, i*10+10));
			else {
				System.out.println(s.substring(i*10, s.length()));	
				break;
			}
		}
		
	}

}
