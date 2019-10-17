
class MinMax<T extends Comparable<T>>
{
	int size = 0;
	boolean isBST = true;
	T min;	//how to initialise as its not always integer
	T max;	//if integer min = Integer.MAX, max = Integer.MIN
}

public class LargestBSTinBT<T extends Comparable<T>> {
	
	int largestBST(Node<T> root)
	{
		MinMax<T> m = largest(root);		
		return m.size;
	}
	
	MinMax<T> largest(Node<T> root)
	{
		if(root == null)
			return new MinMax<T>();
		
		MinMax<T> leftMinMax = largest(root.left);
		MinMax<T> rightMinMax = largest(root.right);
		
		MinMax<T> m = new MinMax<>();
		
		if(!(leftMinMax.isBST || rightMinMax.isBST) || (root.data.compareTo(leftMinMax.max) < 0 || root.data.compareTo(rightMinMax.min) >= 0))
		{
			m.isBST = false;
			m.size = Math.max(leftMinMax.size, rightMinMax.size);
			return m;
		}
		
		//means subtree with current root is also BST
		m.isBST = true;
		m.size = leftMinMax.size + rightMinMax.size + 1;
		
		m.min = (root.left != null ? leftMinMax.min : root.data);
		m.max = (root.right != null ? rightMinMax.max : root.data);
		
		return m;
	}
}
