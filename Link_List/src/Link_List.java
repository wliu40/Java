import java.util.Scanner;
public class Link_List <T> {
	//����һ��˽�е��ڲ���
	//ʹ��java ���ͣ��൱��c++��ģ���࣬����������һ�Լ����ű�����������	
	
	private class Node //ע�⣬�˴�����Ҫ�ٴ�����Node <T>, �ᱻLink_List�ķ����ڸ�
	{
		private T data; //������
		private Node next; //ָ����
		//���캯��֮һ����������
		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		//���캯��֮����һ������
		//nextָ����Ĭ��ָ��null��
		public Node(T data)
		{
			this(data, null); //����д�ڵ�һ��,��this����ǰ����Ǹ����캯��һ��
		}
	}
	//Link_List������ݳ�Ա�ͷ���
	private int size;
	private Node head;
	private Node tail;
	//���캯��
	public Link_List()
	{
		this.size = 0;
		this.head = null;
		this.tail = null;
		
	}
	//�ж������Ƿ�Ϊ��
	public boolean is_empty()
	{
		return head == null;
	}
	//����һ��������,β������½ڵ�
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
	//ͷ������½ڵ�
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
	//ɾ���ڵ�
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
			//�����ǰ�ڵ㵽��Null��Ȼû���ҵ�data��˵���޴˽ڵ㡣
			if (cur == null)
			{
				System.out.println("Can not find the data!\n");
				return;
			}
			else
			{
				//����ǵ�һ���ڵ㣬���⴦��
				if (cur == head)
				{
					head = head.next;
					return;
				}
				//��������һ���ڵ㣬���⴦��
				if(cur == tail)
				{
					tail = pre;				
				}
			}			

			pre.next = cur.next;
			
		}
		//��������ǿյ�
		else
		{
			System.out.println("The link list is empty!\n");
		}
	}
	//��ӡ����������
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


