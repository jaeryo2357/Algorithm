import java.util.Scanner;

public class a_3 {

	public static void main(String[] args)
	{
		System.out.println("/* JAVA to Stack 구현 \n");
		Scanner scanner=new Scanner(System.in);
		
		
		//A_Stack stack=new A_Stack(5);
		A_Queue stack=new A_Queue(5);
		
		
	
		while(true)
		{
			int n;
			System.out.print("사용할 기능을 선택 (0: 삽입, 1: 반환, 2: 모두 제거 ,3:종료) :");
			n=scanner.nextInt();
			if(n==3)
				break;
			
			switch(n)
			{
			case 0:
				System.out.print("삽입할 값:");
				int data=scanner.nextInt();
				if(stack.push(data))
					System.out.println("삽입 성공");
				break;
			case 1:
				Integer check_num=stack.pop();
				if(check_num==null)
				System.out.println("반환할 값이 없습니다.");
				else
					System.out.println("반환값은 "+check_num);
				break;
			case 2:
				while(!stack.IsEmpty())
				{
					System.out.println("반환값은 "+stack.pop());
				}
				break;
	
			}
			
		}
	}
}
