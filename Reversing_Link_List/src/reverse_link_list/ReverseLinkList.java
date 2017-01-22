/*Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5*/

package reverse_link_list;
import java.util.Iterator;
import java.util.Scanner;


public class ReverseLinkList <Item> implements Iterable <Item> 
{
	private class Node
	{
		Item info;
		Node next;
		public Node(Item info)
		{
			this.info = info;
			this.next = null;
		}
	}
	private int size;
	private Node head; //head是虚节点；
	private Node tail; //tail是实际的节点
	
	public ReverseLinkList()
	{
		head = new Node(null);		
		tail = null;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	public int getSize()
	{
		return size;
	}
		
	public boolean isEmpty()
	{
		return head.next == null;
	}
	
	public void append (Item info)
	{
		if ( !isEmpty() )
		{
			tail.next = new Node(info);
			tail = tail.next;			
		}
		else
		{
			head.next = tail = new Node(info);			
		}
		size++;
	}

	public Iterator<Item> iterator()
	{
		return new myIterator();
	}

	private class myIterator implements Iterator <Item>
	{
		private Node cur = head.next;
		public boolean hasNext()
		{
			return cur != null;
		}
		public Item next()
		{
			Item item = cur.info;
			cur = cur.next;
			return item;
		}
		public void remove(){}
	}
	/* 假设k = 3; head是个虚节点。假设start = head;
	 * null --> 1 --> 2 --> 3 --> 4 --> 5--> 6 --> 7 --> 8 -->....
	 *   |		|	  |
	 * start   pre	 cur
	 *     （new_start）
	 * -------------------经过一次reverse内for循环以后：------------------------
	 * null --> 1 <-- 2 <-- 3     4 --> 5 --> 6 --> 7 --> 8 -->....
	 *   |			 	    |	  |
	 * start  	            pre  cur
	 * -------------------for循环后面两句以后：------------------------
	 * null --> 3 --> 2 --> 1 --> 4 --> 5 --> 6 --> 7 --> 8 -->....
	 *   |		|	 	   	|     |
	 * start   pre	     （new_start） cur
	 * ----------------return new_start,然后new_start又作为参数start开始下一轮--------------
	 * null --> 3 --> 2 --> 1 --> 4 --> 5 --> 6 --> 7 --> 8 -->....
	 * 						|     |     |
	 * 					  start  pre   cur
	 * 						  （new_start）
	 * -------------------经过一次reverse内for循环以后：------------------------
	 * null --> 3 --> 2 --> 1 --> 4 <-- 5 <-- 6     7 --> 8 -->....
	 * 						|	  	          | 	|	
	 * 					  start				 pre   cur
	 * -------------------for循环后面两句以后：------------------------
	 * null --> 3 --> 2 --> 1 --> 6 --> 5 --> 4 --> 7 --> 8 -->....
	 * 						|	  |	 	   	  |     |
	 * 					  start  pre    （new_start） cur
	 * ----------------return new_start,然后new_start又作为参数start开始下一轮--------------
	 * null --> 3 --> 2 --> 1 --> 6 --> 5 --> 4 --> 7 --> 8 --> 9 -->...	  
	 * 									      |     |     |
	 * 									    start  pre   cur
	 * ................
	 * 
	 * */
	private Node reverse_for_once(Node start,int k)
	{	
		Node pre = start.next;		
		Node cur = pre.next;
		Node new_start = start.next;
		
		for (int i = 0; i < k-1; i++)
		{
			Node tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		start.next.next = cur;
		start.next = pre;
		return new_start;
	}
	public void reverse_all(int k)
	{
		int times = size / k;
		Node new_start = head;
		for(int i = 0; i < times; i++)
		{
			new_start = reverse_for_once(new_start, k);
		}
	}
	
	public static void main(String[] args)
	{
		ReverseLinkList<Integer> rl= new ReverseLinkList<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.print("input the length of linked list: ");
		int length = in.nextInt();
		for (int i = 1; i <= length; i++)
		{
			rl.append(i);
		}
		System.out.println("size = " + rl.getSize());
		//Iterator <Integer> iter = rl.iterator();
		System.out.print("The linked list is: \n");
		for (Integer item : rl)
		{
			System.out.print( item + " ");
		}
		System.out.print("\nInput the value k: ");
		int k = in.nextInt();
		rl.reverse_all(k);
		in.close();
		System.out.print("The reversing linked list is: \n");
		for (Integer item : rl)
		{
			System.out.print( item + " ");
		}
		
				
	}
}
