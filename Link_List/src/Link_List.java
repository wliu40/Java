import java.util.Scanner;
public class Link_List <T> {
	//定义一个私有的内部类
	//使用java 泛型，相当于c++的模板类，在类名后，用一对尖括号表明泛型名称	
	
	private class Node //注意，此处不需要再次声明Node <T>, 会被Link_List的泛型掩盖
	{
		private T data; //数据域
		private Node next; //指针域
		//构造函数之一，两个参数
		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		//构造函数之二，一个参数
		//next指针域默认指向null；
		public Node(T data)
		{
			this(data, null); //必须写在第一句,用this调用前面的那个构造函数一。
		}
	}
	//Link_List类的数据成员和方法
	private int size;
	private Node head;
	private Node tail;
	//构造函数
	public Link_List()
	{
		this.size = 0;
		this.head = null;
		this.tail = null;
		
	}
	//判断链表是否为空
	public boolean is_empty()
	{
		return head == null;
	}
	//创造一个新链表,尾部添加新节点
	public void add_to_tail(T data)
	{
		if (!is_empty())
		{
			tail.next = new Node(data);			
			tail = tail.next;
		}
		else
		{
			head = tail = new Node(data);			
		}
		size++;
	}
	//头部添加新节点
	public void add_to_head(T data)
	{
		if (!is_empty())
		{
			Node n = new Node (data);
			n.next = head;
			head = n;
		}
		else
		{
			head = tail = new Node (data);
		}
		size++;
	}
	//删除节点
	public void delete(T data)
	{
		if (!is_empty())
		{
			Node pre = null;
			Node cur = head;
			while (cur != null)
			{
				if (cur.data.equals(data))
				{
					break;
				}
				else
				{
					pre = cur;
					cur = cur.next;
				}

			}
			//如果当前节点到了Null仍然没有找到data，说明无此节点。
			if (cur == null)
			{
				System.out.println("Can not find the data!\n");
				return;
			}
			else
			{
				//如果是第一个节点，特殊处理
				if (cur == head)
				{
					head = head.next;
					return;
				}
				//如果是最后一个节点，特殊处理
				if(cur == tail)
				{
					tail = pre;				
				}
			}			

			pre.next = cur.next;
			
		}
		//如果链表是空的
		else
		{
			System.out.println("The link list is empty!\n");
		}
	}
	//打印出整个链表
	public void show()
	{
		if (is_empty())
		{
			System.out.println("Empty link list\n");
		}
		else
		{
			Node  n = head;
			while (n != null)
			{
				System.out.print(n.data + " ");
				n = n.next;
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		Link_List <String> lk = new Link_List <String>();
//		lk.add_to_tail("Eric");
//		lk.add_to_tail("Qiuqiu");
//		lk.add_to_tail("Cynthia");
//		lk.add_to_head("Heihei");
//		lk.add_to_head("Miemie");
//		lk.delete("Heihei");
		while (true)
		{
			String s;
			Scanner in = new Scanner(System.in);			
			System.out.print("please input the name(end with 'q'): ");
			s = in.nextLine();
			if(s.equals("q"))
			{
				break;
			}
			else
			{				
				lk.add_to_tail(s);
			}
			in.close();
			
		}
		System.out.println("The list you have created is:");
		lk.show();
		Scanner in = new Scanner(System.in);
		System.out.print("\nInput the name you want to delete: ");
		String s = in.nextLine();		
		lk.delete(s);
		System.out.println("Now the list is: ");
		lk.show();
		in.close();
		
		
	}
}


