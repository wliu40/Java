//=====================week 1============================

//		ctrl + / 的快捷键操作，注释；
//		alt + / 的快捷键操作：intelligent input（智能补全输入）
//      final int amount = 100;


package hello;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
//		String s = "abc";
//		System.out.println("Hello World!");
//		System.out.println(s);
		Scanner in = new Scanner(System.in);
//		System.out.println(in.nextLine());
//		System.out.println(2 + 3 + " = 2 + 3 = " + (2 + 3));
		final int amount = 100; //常量用final修饰
		int price;
		System.out.print("Please input the price: ");
		price = in.nextInt();
		System.out.print("I should pay back: ");
		System.out.println(amount + " - " + price + " = " + (amount - price));
//		------------------------------------------------------------------------
		System.out.println(100.3-1.1);
		double a = (int)(10.0/3.0);
		System.out.println("a = " + a);
		for (int i = 0; i <10; i++)
		{
			
		}
		
		System.out.println((int)10.5221);
		int xx = in.nextInt() % 4;
		System.out.println("xx: " + xx );
		System.out.printf("xx = %d", xx);
		
		
		in.close();

	}

}
