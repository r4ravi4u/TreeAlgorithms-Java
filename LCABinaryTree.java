//Lowest Common Ancestor in Binary Tree (Not BST)
public class LCABinaryTree<T extends Comparable<T>> {
	
	public Node<T> lcaBT(Node<T> root, T data1, T data2)
	{
		if(root == null || root.data.equals(data1) || root.data.equals(data2))
			return root;
				
		Node<T> left = lcaBT(root.left, data1, data2);
		Node<T> right = lcaBT(root.right, data1, data2);
		
		if(left == null && right == null)
			return null;
		
		if(left != null && right != null)
			return root;	//means this is LCA
		
		return (left != null ? left : right);
	}
}
