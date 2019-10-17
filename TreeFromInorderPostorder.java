
public class TreeFromInorderPostorder {
	
	Node createTree(int[] in, int[] post)
	{
		return createTree(in, post, 0, in.length - 1, post.length - 1);
	}
	
	Node createTree(int[] in, int[] post, int start, int end, int index)
	{
		if(start > end)
			return null;
		
		int i;
		for(i = start; i <= end; i++)
		{
			if(post[index] == in[i])
				break;
		}
		
		Node root = new Node(post[index]);
		
		root.left = createTree(in, post, start, i-1, index - (end - i + 1));
		root.right = createTree(in, post, i+1, end, index - 1);
		
		return root;
	}
}
