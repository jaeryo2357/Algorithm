
public class A_Stack {

	int[] stack_data;
	int index=-1;
	
	public A_Stack(int length) {
		stack_data= new int[length]; 
	}
	
	public boolean IsEmpty() {
		if(index==-1)
			return true;
		else
			return false;
	}
	
	public boolean push(Integer data)
	{
		if(stack_data.length<=index)
			return false;
		else {
		stack_data[++index]=data;
		return true;
		}
	}
	
	public Integer pop()
	{
		if(index>-1)
		return stack_data[index--];
		else  // 아이탬이 없으면 null    -1을 에러값으로 지정하고 int형을 받으면 사용자가 -1을 넣었을 때  혼동 예상
		return null; 
	}
}
