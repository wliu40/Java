// 温度转换， 华氏转为摄氏温度。
//第一周作业。

package temperature;

import java.util.Scanner;


public class Temperature {
	public static void fun(int x){
		int digit = 0;
		while(x != 0){
			digit = x%10;
			System.out.print(digit + " ");
			x /= 10;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int F = 0;
//		
//		Scanner in = new Scanner(System.in);
//		F = in.nextInt();
//		int C = 0;
//		C = (int)((F - 32.0) / 9 * 5);
//		System.out.print(C);
//		in.close();	
		
		char c = 'c';
		String s = "Abc";
		System.out.println((int)s.charAt(0));
		fun(1203450);
		
		
	}

}
