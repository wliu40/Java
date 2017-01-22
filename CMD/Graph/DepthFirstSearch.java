public class DepthFirstSearch

{
	private boolean[] marked; // 一个size与vertices相等的布尔型array；
	private int count; // 计数器
	
	//private int[] edgeTo;
	//private final int s;

	public DepthFirstSearch(Graph G, int s)
	{
		marked = new boolean[G.V()];

		//edgeTo = new int[G.V()];
		//this.s = s;
		dfs(G, s);

	}

	public boolean marked(int w)
	{
		return marked[w];
	}

	public int count()
	{
		return count;
	}

	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		count++;
		
		for (int w : G.adj(v))
		{
			if (!marked[w])
			{
				//edgeTo[w] = v;
				dfs(G, w);
				System.out.println("now is checking: "+ w);
			}
			//System.out.println("now is checking: "+ v);
		}
	}

	
//	public boolean hasPathTo(int v)
//	{
//		return marked[v];
//	}
	
//	public Iterable<Integer> pathTo(int v)
//	{
//		if(!hasPathTo(v))
//			return null;
//		Stack<Integer> path = new Stack<Integer>();
//		for (int x = v; x != s ; x = edgeTo[x])
//			path.push(x);
//		path.push(s);
//		return path;
//
//	}

	public static void main(String[] args) 
	{
		In in = new In(args[0]);
		Graph G = new Graph(in);
		//StdOut.println(G);
		
		DepthFirstSearch dfs = new DepthFirstSearch(G, 0);

		//dfs.dfs(G, 0);
		System.out.println("Hello World!");

	}
}
