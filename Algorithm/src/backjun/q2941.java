package backjun;

import java.util.*;

public class q2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arpha[]= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		Scanner scanner=new Scanner(System.in);
		
		String test=scanner.next();
		int arphaN=0;
		for(int i=0;i<arpha.length;i++)
		{
			int n=test.length();
			test=test.replaceAll(arpha[i],",");
			
		}
		
		System.out.println(test.length());
	}

}
