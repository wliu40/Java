/*我们认为2是第一个素数，3是第二个素数，5是第三个素数，依次类推。
 *现在，给定两个整数n和m，0<n<=m<=200，你的程序要计算第n个素数到第m个素数之间所有的素数的和，
 *包括第n个素数和第m个素数.
 *--------------------------------
 * 输入格式：两个整数，第一个表示n，第二个表示m。
 * 输出格式：一个整数，表示第n个素数到第m个素数之间所有的素数的和，包括第n个素数和第m个素数。
 * */

import java.util.Scanner;
import java.lang.Math;
public class PrimeSum {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		int sum = 0;
		int cnt = 0;
		int i = 2;
		while (true)
		{
			if (isPrime(i))
			{
				
				cnt++;
				if (cnt > m-1 )
				{
					System.out.print(i + " ");
					sum += i;
				}				
			}

			if (cnt > n - 1)
				break;
			i++;
		}
		System.out.println("sum = " + sum);
				
	}
	public static boolean isPrime(int x)
	{
		boolean flag = true;
		int limit = (int)Math.sqrt((double)(x));
		for (int i = 2; i <= limit; i++)
		{
			if (x%i == 0)
			{
				flag = false;
				break;				
			}
		}
		return flag;		
	}
}
