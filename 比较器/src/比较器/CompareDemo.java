/* 为什么要继承Comparable，怎样继承
 * 关键词：ArrayList, Collections.sort(), Integer.compare(a, b)
 * a.compareTo(b); 
 * */

package 比较器;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class CompareDemo  {
	
/*如果继承了Comparable接口，则必须要实现Comparable的方法：int compareTo()*/
	private class Student implements Comparable<Student>
	{
		private String firstName;		
		private int age;
		private double score;
		public Student(String firstName, int age, double score)
		{
			this.firstName = firstName;			
			this.age = age;
			this.score = score;
		}
	/*toString()方法相当于__str__(self) in python*/
		public String toString()
		{
			
			return firstName + "\t\t" + age + "\t\t" + score + '\n';
			
		}
		public int compareTo(Student that)
		{
			int cmp = firstName.compareTo(that.firstName);			
			if (cmp != 0)
				return cmp;
			/*当然，也可以写：
			 * if (age > that.age)
			 * return 1;
			 * if (age == that.age)
			 * return 0
			 * ...*/
			cmp = Integer.compare(age, that.age);
			if(cmp != 0)
				return cmp;
			/*如果姓名，年龄都一样，最后的判断条件是分数*/
			return Double.compare(score, that.score);		
		}		
	}
	
	public void test()
	{
		
		ArrayList <Student> mylist = new ArrayList<Student>();
		mylist.add(new Student("Eric", 20, 95.2));
		mylist.add(new Student("Arvin", 20, 90.2));
		mylist.add(new Student("Eric", 21, 95.2));
		mylist.add(new Student("Eric", 21, 96.2));
		System.out.println(mylist);
		
		
		System.out.println("-------------------");
		for(Iterator <Student> it = mylist.iterator();it.hasNext();)
		{
			System.out.print(it.next());
		}
		
		System.out.println("-------------------");
		Collections.sort(mylist);		
		for(Iterator <Student> it = mylist.iterator();it.hasNext();)
		{
			System.out.print(it.next());
		}
		
		ArrayList <Integer> intlist = new ArrayList<Integer> ();
		intlist.add(1);
		intlist.add(-10);
		intlist.add(12);
		intlist.add(8);
		intlist.add(100);
		intlist.add(0);
		System.out.println(intlist);
		Collections.sort(intlist);
		System.out.println(intlist);
		
		
		
	}
	public static void main(String[] args)
	{
		CompareDemo  cd = new CompareDemo ();
		cd.test();
		
	}
}
