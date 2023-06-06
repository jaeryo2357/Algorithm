package backjun;

import java.util.*;

public class q2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
	
		for(int i=0;i<T;i++) {
		int loop=scanner.nextInt();
		String looptext=scanner.next();
		StringBuilder builder =new StringBuilder();
		  for(int j=0;j<looptext.length();j++)
		  {
			  for(int k=0;k<loop;k++)
			  {
				  builder.append(looptext.charAt(j));
			  }
		  }
		  

			System.out.println(builder.toString());
		}
		
	}

}
