// �¶�ת���� ����תΪ�����¶ȡ�
//��һ����ҵ��

package temperature;

import java.util.Scanner;

public class Temperature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int F = 0;
		
		Scanner in = new Scanner(System.in);
		F = in.nextInt();
		int C = 0;
		C = (int)((F - 32.0) / 9 * 5);
		System.out.print(C);
		in.close();	
	}

}