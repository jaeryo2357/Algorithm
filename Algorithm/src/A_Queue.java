
public class A_Queue {

	int[] data;
	int last;
	
	public A_Queue(int length)
	{
		data=new int[length];
		last=0;
	}
	
	public boolean push(Integer data)
	{
		if(this.data.length<=last)
			return false;
		else {
			this.data[last++]=data;
			return true;
			
		}
	}
	
	public Integer pop() {
		if(last<=0)
			return null;
		else {
			int output=this.data[0];
			for(int i=0;i<last-1;i++)
			{
				data[i]=data[i+1];
			}
			last--;
			return output;
		}
	}
	
	public boolean IsEmpty() {
		if(last<=0)
		return true;
		else
			return false;
		
	}
}
