package stack;
import java.util.Iterator;
import java.util.Scanner;

/*************************************
 *  	用链表结构实现的Stack数据集合类	     *
 * 关键词：内部类，泛型，迭代器，使用forEach方法     *
 * ***********************************/

/* Stack implements Iterable 的后果是：Stack必须实现Iterator<Item>.iterator();方法
 * 该方法要求Stack类中实现了iterator()方法，该方法可以返回一个Stack内部迭代器类的一个对象；
 * 该Stack内部迭代器类是自己定义的，但是需要实现Iterator接口；
 */
/* 为什么需要接口？
 * 接口等同于一种规范，就是要实现这个接口，你就必须实现接口的方法，完成相应的功能。
 * 如果没有接口， 那么在实现的时候，很可能遗漏方法、或者定义的方法不统一。
 *  
 * */
public class Stack <Item> implements Iterable<Item> 
{
	/*Node是Stack的内部类；
	 *所以不需要在Node的后面再注明泛型<Item>
	 */
	private class Node
	{
		Item data;
		Node next;
		public Node (Item data)
		{
			this.data = data;
			next = null;
		}
	}
	/*成员变量：链表大小，链表的头（栈的头）*/
	private int size;
	private Node head;
	/* Stack类并没有定义构造函数；
	 * 当然这意味着会有一个默认的空参数的构造函数；
	 * 所以创建新对象时：Stack <Item> sk = new Stack<Item>();
	 * */
	public boolean isEmpty()
	{
		return head == null;
	}
	/*压栈*/
	public void push(Item data)
	{
		Node oldHead = head;
		head = new Node(data);
		head.next = oldHead;
		size++;		 
	}
	/*出栈*/
	public Node pop()
	{
		Node n = head;
		head = head.next;
		size--;
		return n;
	}
	
	/* 实现iterator方法， 返回一个Iterator对象*/	
	public Iterator <Item> iterator()
	{
		return new myIterator();
	}
	
	/*内部类，实现了Iterator接口
	 *必须实现三个方法：1.hasNext();2.next();3.remove();
	 *因为myIterator是属于Stack的内部类，所以myIterator后面不能声明泛型；
	 *这与Node是Stack的内部类是一个道理；
	 */
	private class myIterator implements Iterator<Item>
	{
		private Node cur = head;
		public Item next() //取出当前元素，并将指针移到下一元素，（通过对成员变量cur的修改)
		{
			Item x = cur.data;
			cur = cur.next;
			return x;
		}
		public boolean hasNext()
		{
			return cur != null;
		}
		public void remove(){}
	}
	
	public static void main(String[] args)
	{
		Stack<String> sk = new Stack<String>();
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		while (!s.equals("q"))
		{
			sk.push(s);
			s = in.nextLine();
		}
		in.close();
		System.out.println("--------------------");
	  //System.out.println(sk.pop().toString());
      //System.out.println(sk.pop().data);
		for (String x : sk)
		{
			System.out.println(x);
		}
		System.out.println("--------------------");
		
		Iterator <String> iter = sk.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		
	}
	
}
