package Sort;

public class quickSort {

	
	public static void swap(String a[],int i,int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	
	public static int partion(String[] a,int start,int end)
	{
		String pivot=a[end];
		int index1=start-1;
		
		for(int index2=start;index2<=end-1;index2++)
		{
			if(a[index2].compareTo(pivot)<0)
			{
				swap(a,++index1,index2);
			}
				
		}
		swap(a,index1+1,end);
		
		return index1+1;
	}
	
	
	public static void quickSort(String[] a,int start,int end)
	{
		if(start>=end)return;
		int middle=partion(a,start,end);
		quickSort(a,start,middle-1);
		quickSort(a,middle+1,end);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input=new String[] {"양민욱","구동섭","임수현"};
		quickSort(input,0,input.length-1);
	}

}
