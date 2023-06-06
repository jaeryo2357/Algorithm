package backjun;

import java.util.Scanner;

public class q9498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N;
		Scanner scanner=new Scanner(System.in);
		N=scanner.nextInt();
		
		if(100>=N&&N>=90)
			System.out.println("A");
		else if(90>N&&N>=80)
			System.out.println("B");
		else if(80>N&&N>=70)
			System.out.println("C");
		else if(70>N&&N>=60)
			System.out.println("D");
		else
			System.out.println("F");
		scanner.close();
	}
	
}
