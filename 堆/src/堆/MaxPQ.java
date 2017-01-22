package 堆;
/********************************
 * 1.类MaxPQ展示了如何每次插入一个数据，并维持一个最大堆；
 * 2.同时，也展示了如何传入一个无序数组，然后把这个数组变成一个最大堆，再然后把最大堆进行堆排序
 * 3.还包括了关于泛型的一些知识。
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
	
	private key[] array; //优先队列，元素是key类型，key extends Comparable,所以可比较
	private int N = 0; //优先队列存储于array[1,2,....N], array[0]是哨兵
	public MaxPQ(int maxN) //优先队列的大小
	{
		array = (key[]) new Comparable [maxN + 1];
	}
	/* Why don't use: array = (key[]) new key [maxN + 1];?
	 * --------------------------------------------------------------
	 * class 小鸟 extends Flyable
		说明 小鸟是可以飞的..Flyable f = new 小鸟().
		可是 可以飞的是小鸟..小鸟 bird = new Flyable().你觉提这对吗？难道飞机不能飞么？
		凭什么把一个可以飞的东西确定为小鸟（赋值给小鸟对象）？
		哦，原来你指的可以飞的东西就是小鸟呀。＝＝>小鸟 bird = (小鸟)(new Flyable()).
		特指(强制转换)一下就好了。
		-----------------------------------------------------------
		class Student extends Person
		Person s = new Student(); --->OK
		Student s = (Student)new Person(); ---->need cast to Student
	 * ------------------------------------------------------------
	 * You can't create arrays of a generic type because the type information 
	 * doesn't exist at runtime. As 'key' extends Comparable, that is the only 
	 * 'concrete' type that can be used
	 * */
	

/*输入一个数组，先把这个数组拷贝给成员变量array,然后对array进行操作，从array.length/2到1号元素，依次sink*/
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
/*传给一个数据，把该数据插入到堆中*/	
	public void insert(key x)
	{
		array[++N] = x;
		swim(N);
	}
/*删除最大元素（堆顶元素），并返回其值*/
	public key deleteMax()  
	{
		key max = array[1];
		exch(1, N);
		N--;
		sink(1);
		return max;
	}
/*交换队列中两个元素的位置*/	
	private void exch(int i, int j)
	{
		key tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
/*堆中的底层元素，如何“游”到适当的位置，以维持最大堆*/		
	private void swim(int i)
	{

		while (i/2 >= 1)
		{
			if (array[i].compareTo(array[i/2]) > 0)
				exch(i, i/2);
			i = i/2;
		}
	}
/*堆中的顶层元素，如何“沉”到适当的位置，以维持最大堆*/		
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
/*对最大堆进行堆排序*/	
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
		System.out.println("实验一：依次取出数组中元素，并插入/维持一个最大堆：");
		Integer[] arr = {21,5,6,1,10,8,12};
		MaxPQ <Integer> pq = new MaxPQ<Integer>(arr.length);
		for(int i = 0; i < arr.length; i++)
		{
			pq.insert(arr[i]); //每次从arr中取一个值，并插入到堆中
		}
		pq.show();
		System.out.println("-------------------------------");
		System.out.println("实验二：先拷贝数组给成员变量array，然后建造一个最大堆，再然后进行堆排序：");
		Integer[] arr1 = {21,5,6,1,10,8,12};
		MaxPQ <Integer> pq1 = new MaxPQ<Integer>(arr1.length);
		System.out.println("step1:建立一个大小为arr1.length的数组，此时数组元素都是null:");
		pq1.show();
		System.out.println("step2:把这个数列copy给成员变量array,然后再把array修改为一个最大堆:");
		pq1.transform(arr1); 
		pq1.show();
		System.out.println("step3:对建立好的最大堆进行堆排序:");
		pq1.sort();
		pq1.show();

	}

}
