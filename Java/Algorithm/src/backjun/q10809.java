package backjun;

import java.util.*;
public class q10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		String s=scanner.next();
		
		for(char a='a';a <='z';a++)
		{
			System.out.print(s.indexOf(a)+" ");
		}
		scanner.close();
	}

}
