package backjun;

import java.util.*;

public class q11656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		String s=scanner.next();
		String[] t=new String[s.length()];
		
		for(int i=0;i<s.length();i++)
		{
			t[i]=s.substring(i);
		}
		
		Arrays.sort(t);
		
		for(int i=0;i<t.length;i++)
		{
			System.out.println(t[i]);
		}
		
		
		scanner.close();
	}

}
