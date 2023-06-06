package backjun;

import java.util.*;
public class q1475 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
        int[] caseN= {0,0,0,0,0,0,0,0,0};
        
        String s=scanner.next();
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            char a;
            if(s.charAt(i)=='9')
                a='6';
            else a=s.charAt(i);
            
            caseN[a-'0']++;
           
            if(caseN[a-'0']>max) {
            	if(a=='6')
            		max=caseN[a-'0']/2+caseN[a-'0']%2;
            	else
            	max=caseN[a-'0'];
            }
        }
       
		
		System.out.println(max);
        scanner.close();
	}

}
