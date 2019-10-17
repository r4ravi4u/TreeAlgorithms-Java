
public class TreeFromInorderPreorder {
	
	int index = 0;
	Node createTree(int[] inOrder, int[] preOrder)
	{
		Node root = createTree(inOrder, preOrder, 0, inOrder.length-1);
		index = 0;
		return root;
	}
	
	Node createTree(int[] in, int[] pre, int start, int end)
	{
		if(start > end)
			return null;
		
		int i;
		for(i = start; i <= end; i++)
		{
			if(in[i] == pre[index])
				break;
		}
		
		Node root = new Node(pre[index]);
		index++;
		
		root.left = createTree(in, pre, start, i-1);
		root.right = createTree(in, pre, i+1, end);
		
		return root;
	}

}
