package ¶þ²æÊ÷;
import java.util.Stack;
/* boolean empty(); Returns true if the stack is empty
 *  Object peek(); 
 *  	Returns the element on the top of the stack, but does not remove it.
 *  
 *  Object pop();
 *  	Returns the element on the top of the stack, removing it in the process.
 *  
 *  Object push(Object element);
 *  	Pushes element onto the stack. element is also returned.
 *  
 *  int search(Object element);
 *  	Searches for element in the stack. 
 *  	If found, its offset from the top of the stack is returned. 
 *  	Otherwise, 1 is returned;
 */
public class BST{

	private class Node{
		public Node(int info){
			this.info = info;
			left = null;
			right = null;
		}
		private int info;
		private Node left;
		private Node right;
	}
	
	private int size = 0;
	private Node root = null;
	public boolean isEmpty(){
		return root == null;
	}
	
	public void create(int[] array){	
		for (int i = 0; i < array.length; i++)
		{
			addNode(array[i]);			
			size++;
		}
	}
	
	public void addNode(int item){
		if (isEmpty()){
			root = new Node(item);
			System.out.println("root = "+root.info);
		}
		else{
			Node cur = root;
			while (true){
				if (item < cur.info){
					if(cur.left != null)
						cur = cur.left;
					else{
						
						cur.left = new Node(item);
						break;
					}						
				}
				else{
					if (cur.right != null)
						cur = cur.right;
					else{
						cur.right = new Node(item);
						break;
					}
				}
			}
		}
	}
	public Node getRoot(){
		return root;
	}
	public void InOrderNoneRecursive(){		
		Node node = root;
		Stack <Node> stack = new Stack<Node>();
		while( node != null || !stack.empty()){
			while (node != null){
				stack.push(node);
				//System.out.println("push("+node.info+")");
				node = node.left;
				
			}
			node = stack.pop();
			System.out.print(node.info + " ");
			node = node.right;
		}
	}
	public void InOrderRecursive(Node node){		
		if (node != null)
		{
			InOrderRecursive(node.left);
			System.out.print(node.info + ", ");
			InOrderRecursive(node.right);
		}
	}
	public static void main(String[] args)
	{
		BST  bst = new BST ();
		int[] array = {10,15,2,3,9,14,0,18,16,-1,4};
		bst.create(array);
		bst.InOrderNoneRecursive();
		System.out.println();
		bst.InOrderRecursive(bst.getRoot());
		
	}
}
