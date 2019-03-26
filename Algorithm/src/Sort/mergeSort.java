package Sort;

import java.util.Arrays;

public class mergeSort {

	
	
	public static void mergeSort(String a[],int start,int end)
	{
		if(start==end)return;
		int middle=(start+end)/2;
		mergeSort(a,start,middle);
		mergeSort(a,middle+1,end);
		merge(a,start,middle,end);
	}
	
	public static void merge(String a[],int start,int middle,int end)
	{
		int length=end-start+1; //temp배열의 길이
		String[] temp=new String[length];
		int tempIndex=0;
		int i=start;
		int j=middle+1;
		
		while(j<=end&&i<=middle)
		{
			if((a[i].compareTo(a[j])<0)) {
				temp[tempIndex++]=a[i++];
			}else
			
				temp[tempIndex++]=a[j++];
		}
		
		while(i<=middle)temp[tempIndex++]=a[i++];
		while(j<=end)temp[tempIndex++]=a[j++];
		
		for(int copyi=0;copyi<temp.length;copyi++)
		{
			a[start+copyi]=temp[copyi];
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input = new String[] {"양민욱","임수현","구동섭"};
		mergeSort(input,0,2);
		
		System.out.print(Arrays.toString(input));
	}

}
