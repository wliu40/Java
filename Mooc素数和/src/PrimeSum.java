/*������Ϊ2�ǵ�һ��������3�ǵڶ���������5�ǵ������������������ơ�
 *���ڣ�������������n��m��0<n<=m<=200����ĳ���Ҫ�����n����������m������֮�����е������ĺͣ�
 *������n�������͵�m������.
 *--------------------------------
 * �����ʽ��������������һ����ʾn���ڶ�����ʾm��
 * �����ʽ��һ����������ʾ��n����������m������֮�����е������ĺͣ�������n�������͵�m��������
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
