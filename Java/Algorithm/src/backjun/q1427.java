package backjun;

import java.util.Scanner;

public class q1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		String input=scanner.next();
		char[] sort=input.toCharArray();
		
		QuickSort(sort,0,sort.length-1);
		
		for(int i=0;i<sort.length;i++)
			System.out.print(sort[i]);
	}
	
	
	public static void swap(char[] a,int i,int j)
	{
		char temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void QuickSort(char[] a,int start,int end) {
		if(start>=end)return;
		int key= partion(a,start,end);
		QuickSort(a,start,key-1);
		QuickSort(a,key+1,end);
	}
	
	public static int partion(char[] a,int start,int end)
	{
		swap(a,(start+end)/2,end);
		int value=a[end];
		
		int indexi=start-1;
		
		for(int indexj=start;indexj<end;indexj++)
		{
			if(a[indexj]>=value)
				swap(a,++indexi,indexj);
		}
		swap(a,indexi+1,end);
		
		return indexi+1;
	}

}
