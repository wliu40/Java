package ��;
/********************************
 * 1.��MaxPQչʾ�����ÿ�β���һ�����ݣ���ά��һ�����ѣ�
 * 2.ͬʱ��Ҳչʾ����δ���һ���������飬Ȼ������������һ�����ѣ���Ȼ������ѽ��ж�����
 * 3.�������˹��ڷ��͵�һЩ֪ʶ��
 * */

/* <key extends Comparable <key>>
 * This means that the type parameter must support comparison with other 
 * instances of its own type, via the Comparable interface.
 * ---------------Classes Implementing Comparable---------------
 * 	Byte		Character		Long		Integer	
 * 	Short		Double			Float		BigInteger
 * 	Boolean		File			String		Date		
 * 	CollationKey
 * -------------------------------------------------------------
 * 
 * */
public class MaxPQ <key extends Comparable <key>> {
	
	private key[] array; //���ȶ��У�Ԫ����key���ͣ�key extends Comparable,���ԿɱȽ�
	private int N = 0; //���ȶ��д洢��array[1,2,....N], array[0]���ڱ�
	public MaxPQ(int maxN) //���ȶ��еĴ�С
	{
		array = (key[]) new Comparable [maxN + 1];
	}
	/* Why don't use: array = (key[]) new key [maxN + 1];?
	 * --------------------------------------------------------------
	 * class С�� extends Flyable
		˵�� С���ǿ��Էɵ�..Flyable f = new С��().
		���� ���Էɵ���С��..С�� bird = new Flyable().�����������ѵ��ɻ����ܷ�ô��
		ƾʲô��һ�����ԷɵĶ���ȷ��ΪС�񣨸�ֵ��С����󣩣�
		Ŷ��ԭ����ָ�Ŀ��ԷɵĶ�������С��ѽ������>С�� bird = (С��)(new Flyable()).
		��ָ(ǿ��ת��)һ�¾ͺ��ˡ�
		-----------------------------------------------------------
		class Student extends Person
		Person s = new Student(); --->OK
		Student s = (Student)new Person(); ---->need cast to Student
	 * ------------------------------------------------------------
	 * You can't create arrays of a generic type because the type information 
	 * doesn't exist at runtime. As 'key' extends Comparable, that is the only 
	 * 'concrete' type that can be used
	 * */
	

/*����һ�����飬�Ȱ�������鿽������Ա����array,Ȼ���array���в�������array.length/2��1��Ԫ�أ�����sink*/
	public void transform(key[] a)	
	{
		for (int i = 0; i < a.length; i++)
		{
			int j = i +1;
			array[j] = a[i];
			
		}
		N = a.length;

		for(int i = array.length/2; i >= 2; i--)
		{
			sink(i);
		}
	}
/*����һ�����ݣ��Ѹ����ݲ��뵽����*/	
	public void insert(key x)
	{
		array[++N] = x;
		swim(N);
	}
/*ɾ�����Ԫ�أ��Ѷ�Ԫ�أ�����������ֵ*/
	public key deleteMax()  
	{
		key max = array[1];
		exch(1, N);
		N--;
		sink(1);
		return max;
	}
/*��������������Ԫ�ص�λ��*/	
	private void exch(int i, int j)
	{
		key tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
/*���еĵײ�Ԫ�أ���Ρ��Ρ����ʵ���λ�ã���ά������*/		
	private void swim(int i)
	{

		while (i/2 >= 1)
		{
			if (array[i].compareTo(array[i/2]) > 0)
				exch(i, i/2);
			i = i/2;
		}
	}
/*���еĶ���Ԫ�أ���Ρ��������ʵ���λ�ã���ά������*/		
	private void sink(int i)
	{
		
		while ( 2*i <= N )		
		{			
			int j = 2*i;
			if (j+1 <= N && array[j].compareTo(array[j+1]) < 0)
				j++;
			if (array[i].compareTo(array[j]) > 0)
				break;	
			exch (i, j);			
			i = i*2;
		}
	}
/*�����ѽ��ж�����*/	
	public void sort()
	{
		while ( N > 1)
		{
			exch(1, N--);
			sink(1);
		}
	}
	public void show()
	{		
		for (int i = 1; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("ʵ��һ������ȡ��������Ԫ�أ�������/ά��һ�����ѣ�");
		Integer[] arr = {21,5,6,1,10,8,12};
		MaxPQ <Integer> pq = new MaxPQ<Integer>(arr.length);
		for(int i = 0; i < arr.length; i++)
		{
			pq.insert(arr[i]); //ÿ�δ�arr��ȡһ��ֵ�������뵽����
		}
		pq.show();
		System.out.println("-------------------------------");
		System.out.println("ʵ������ȿ����������Ա����array��Ȼ����һ�����ѣ���Ȼ����ж�����");
		Integer[] arr1 = {21,5,6,1,10,8,12};
		MaxPQ <Integer> pq1 = new MaxPQ<Integer>(arr1.length);
		System.out.println("step1:����һ����СΪarr1.length�����飬��ʱ����Ԫ�ض���null:");
		pq1.show();
		System.out.println("step2:���������copy����Ա����array,Ȼ���ٰ�array�޸�Ϊһ������:");
		pq1.transform(arr1); 
		pq1.show();
		System.out.println("step3:�Խ����õ����ѽ��ж�����:");
		pq1.sort();
		pq1.show();

	}

}
