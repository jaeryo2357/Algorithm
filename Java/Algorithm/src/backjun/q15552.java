package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q15552 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader b1=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter b2=new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int T=Integer.parseInt(b1.readLine());
			
			for(int i=0;i<T;i++)
			{
				StringTokenizer st=new StringTokenizer(b1.readLine());
				int A=Integer.parseInt(st.nextToken());
				int B=Integer.parseInt(st.nextToken());
				b2.write((A+B)+"");
				b2.newLine();
			}
			b2.flush();
			b2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
