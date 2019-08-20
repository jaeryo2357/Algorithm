package kakao;

import java.util.Arrays;
import java.util.Scanner;

public class Kakao1 {

	public static void main(String[] args) {
	
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
		int n= 5;
		
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		//결과 값
		String[] result = new String[n];
		
		
		//replace로 바꾸기
		for(int i=0;i<n;i++)
		{
			int arr = arr1[i] | arr2[i]; //OR연산 
//			
			String temp = Integer.toBinaryString(arr);
			temp=temp.replace("1", "#").replace("0", " ");
			
			result[i]=temp;
		}
		
		System.out.println(Arrays.toString(result));
		
		System.out.println();
		
		//비트연산으로 # 바꿔주기
		String resultString = " ";
		for(int i=0;i<n;i++)
		{
			int arr = arr1[i] | arr2[i]; //OR연산 
 			resultString = "";
 			int targetBit = 1;
			for(int j=0;j<n;j++)
			{
				resultString = ((arr & targetBit)>0?"#":" ") + resultString;
				targetBit = targetBit << 1;
			}
			result[i] = resultString;
		}
		
		System.out.println(Arrays.toString(result));
	}

}
