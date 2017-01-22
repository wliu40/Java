package week3_1;
import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int odd = 0;
		int even = 0;		
		while (n != -1)
		{
			
			if (n % 2 == 0)
			{
				even++;
			}
			else
				odd++;
			n = in.nextInt();
		}
		System.out.print(odd + " " + even);		
		in.close();
	}
	
}
