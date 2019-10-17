
public class TreeFromPreorderPostorder {
	
	Node createTree(int[] pre, int[] post)
	{
		return createTree(pre, post, 0, post.length - 2, 0);
	}
	
	Node createTree(int[] pre, int[] post, int start, int end, int index)
	{
		if(start > end || index >= pre.length-1)
			return new Node(pre[index]);
		
		int i;
		for(i = start; i <= end; i++)
		{
			if(post[i] == pre[index+1])
				break;
		}
		
		Node root = new Node(pre[index]);
		
		root.left = createTree(pre, post, start, i-1, index+1);
		root.right = createTree(pre, post, i+1, end, index+i-start+2);
		
		return root;
	}
	
	public static void main(String args[]){
		TreeFromPreorderPostorder prePost = new TreeFromPreorderPostorder();
		TreeFromInorderPostorder inPost = new TreeFromInorderPostorder();
		TreeFromInorderPreorder inPre = new TreeFromInorderPreorder();
		
		int inorder[] = {2, 1, 6, 3, 8, 7, 9};
		int preorder[] = {1, 2, 3, 6, 7, 8, 9};
        int postorder[] = {2, 6, 8, 9, 7, 3, 1};
        
        Node<Integer> root; 
        //root = prePost.createTree(preorder, postorder);
        //root = inPost.createTree(inorder, postorder);
        root = inPre.createTree(inorder, preorder);
        
        BST<Integer> tree = new BST();
        
        tree.inOrder(root);
        System.out.println();
        
        tree.preOrder(root);
        System.out.println();
        
        tree.postOrder(root);
    }
}
