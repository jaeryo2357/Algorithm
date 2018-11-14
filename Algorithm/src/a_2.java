
public class a_2 {
	   public static int expressions(int num) {
		      int answer = 1;
		      
		      for(int i=num-1;i>0;i--)
		      {
		    	  int c=check(i,num);
		    	  if(c==1)
		    	   answer++;
		    	  else if(c==-1)
		    		  break;
		      }

		      return answer;
		   }
	   
	   public static int check(int n,int check_num) {
		  
		   int result =n;
		   for(int i=n-1;i>0;i--)
		   {
			   result +=i;
			if(result>check_num) {
				return 0;
			}
			else if(result==check_num)
				return 1;
		   }
		   return -1;

	   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(expressions(15));
	}

}
