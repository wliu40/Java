package stack;
import java.util.Iterator;
import java.util.Scanner;

/*************************************
 *  	������ṹʵ�ֵ�Stack���ݼ�����	     *
 * �ؼ��ʣ��ڲ��࣬���ͣ���������ʹ��forEach����     *
 * ***********************************/

/* Stack implements Iterable �ĺ���ǣ�Stack����ʵ��Iterator<Item>.iterator();����
 * �÷���Ҫ��Stack����ʵ����iterator()�������÷������Է���һ��Stack�ڲ����������һ������
 * ��Stack�ڲ������������Լ�����ģ�������Ҫʵ��Iterator�ӿڣ�
 */
/* Ϊʲô��Ҫ�ӿڣ�
 * �ӿڵ�ͬ��һ�ֹ淶������Ҫʵ������ӿڣ���ͱ���ʵ�ֽӿڵķ����������Ӧ�Ĺ��ܡ�
 * ���û�нӿڣ� ��ô��ʵ�ֵ�ʱ�򣬺ܿ�����©���������߶���ķ�����ͳһ��
 *  
 * */
public class Stack <Item> implements Iterable<Item> 
{
	/*Node��Stack���ڲ��ࣻ
	 *���Բ���Ҫ��Node�ĺ�����ע������<Item>
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
	/*��Ա�����������С�������ͷ��ջ��ͷ��*/
	private int size;
	private Node head;
	/* Stack�ಢû�ж��幹�캯����
	 * ��Ȼ����ζ�Ż���һ��Ĭ�ϵĿղ����Ĺ��캯����
	 * ���Դ����¶���ʱ��Stack <Item> sk = new Stack<Item>();
	 * */
	public boolean isEmpty()
	{
		return head == null;
	}
	/*ѹջ*/
	public void push(Item data)
	{
		Node oldHead = head;
		head = new Node(data);
		head.next = oldHead;
		size++;		 
	}
	/*��ջ*/
	public Node pop()
	{
		Node n = head;
		head = head.next;
		size--;
		return n;
	}
	
	/* ʵ��iterator������ ����һ��Iterator����*/	
	public Iterator <Item> iterator()
	{
		return new myIterator();
	}
	
	/*�ڲ��࣬ʵ����Iterator�ӿ�
	 *����ʵ������������1.hasNext();2.next();3.remove();
	 *��ΪmyIterator������Stack���ڲ��࣬����myIterator���治���������ͣ�
	 *����Node��Stack���ڲ�����һ������
	 */
	private class myIterator implements Iterator<Item>
	{
		private Node cur = head;
		public Item next() //ȡ����ǰԪ�أ�����ָ���Ƶ���һԪ�أ���ͨ���Գ�Ա����cur���޸�)
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
