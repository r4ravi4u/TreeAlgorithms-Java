import java.util.*;

class Node<T extends Comparable<T>>
{
	T data;
	Node<T> left;
	Node<T> right;
	
	public Node(T data)
	{
		this.data = data;
		left = right = null;
	}
}
public class BST<T extends Comparable<T>> {
	
	Node<T> root;
	
	Node<T> insert(T data)
	{		
		return root = insert(root, data);
	}
	
	Node<T> insert(Node<T> node, T data)
	{
		if(node == null)
			return new Node<>(data);
	
		if(data.compareTo(node.data) < 0)	//left side
			node.left = insert(node.left, data);
		
		else
			node.right = insert(node.right, data);
		
		return node;
	
	}
	
	Node<T> delete(T data)
	{
		root = delete(root, data);		
		return root;
	}
	
	Node<T> delete(Node<T> node, T data)
	{
		if(node == null)
			return node;
		
		if(data.compareTo(node.data) < 0)
			node.left = delete(node.left, data);
		
		else if(data.compareTo(node.data) > 0)
			node.right = delete(node.right, data);
		
		else	//found the data
		{
			//Case 1 : Leaf Node OR 1 child only
			if(node.left == null)
				return node.right;
			if(node.right == null)
				return node.left;
			
			//Case 2 : 2 children node
			//copy data of leftmost child in right node -> inorder successor
			//delete that inorder successor node
			node.data = copyUtil(node.right);	//copy data
			node.right = delete(node.right, node.data);	//delete that node 
		}
		
		return node;
	}
	
	T copyUtil(Node<T> node)
	{
		T data = node.data;
		while(node.left != null)
		{
			data = node.left.data;
			node = node.left;
		}		
		
		return data;
	}
	
	int height(Node<T> root)
	{
		if(root == null)
			return 0;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		return Math.max(lh, rh) + 1;
	}
	
	int size(Node<T> root)	//no. of nodes in a tree
	{
		if(root == null)
			return 0;
		
		int ls = size(root.left);
		int rs = size(root.right);
		
		return ls + rs + 1;
	}
	
	void inOrder(Node<T> root)
	{
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data + ", ");
		inOrder(root.right);		
	}
	
	void preOrder(Node<T> root)
	{
		if(root == null)
			return;
		
		System.out.print(root.data + ", ");
		preOrder(root.left);
		preOrder(root.right);		
	}
	
	void postOrder(Node<T> root)
	{
		if(root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + ", ");
	}
	
	void levelOrder(Node<T> root)
	{
		if(root == null)
			return;
		
		Queue<Node<T>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty())
		{
			Node<T> node = q.poll();
			if(node == null)
			{
				System.out.println();
				continue;
			}				
			System.out.print(node.data + ", ");
			
			if(node.left != null)
				q.offer(node.left);
			if(node.right != null)
				q.offer(node.right);
			
			if(q.peek() == null)
				q.offer(null);
		}
	}
	
	boolean search(T data)
	{
		return search(root, data);
	}
	
	boolean search(Node<T> root, T data)
	{
		if(root == null)
			return false;
		
		if(data.compareTo(root.data) < 0)
			return search(root.left, data);
		
		else if(data.compareTo(root.data) > 0)
			return search(root.right, data);
		
		return true;
			
	}
	
	public static void main(String args[]){
		BST<Integer> bst = new BST<>();
        bst.insert(10);
        bst.insert(15);
        bst.insert(5);
        bst.insert(7);
        bst.insert(19);
        bst.insert(20);
        bst.insert(-1);
        bst.insert(21);
        
        /*System.out.println((new BST<Integer>()).size(bst.root));
        
        bst.inOrder(bst.root);*/
        /*List<Integer> result = new ArrayList<>();
        if(RootToLeafSum.rootToLeafSum(bst.root, 14, result))
        	System.out.println(result);
        else
        	System.out.println("False");*/
        
        bst.levelOrder(bst.root);
        
        //System.out.println(bst.search(-7));
        
    }
}
