
public class AVLTree {
	
	int height(Node<Integer> root)
	{
		if(root == null)
			return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	Node rotateRight(Node<Integer> root)
	{
		Node<Integer> temp = root.left;
		root.left = temp.left.right;
		temp.right = root;
		return temp;
	}
	
	Node rotateLeft(Node<Integer> root)
	{
		Node<Integer> temp = root.right;
		root.right = root.right.left;
		temp.left = root;
		return temp;
	}
	
	Node insertAVLTree(Node<Integer> root, int data)
	{
		if(root == null)
			return new Node(data);
		
		if(data < root.data)
			root.left = insertAVLTree(root.left, data);
		
		else
			root.right = insertAVLTree(root.right, data);
		
		int balance = height(root.left) - height(root.right);
		
		if(balance > 1) //LL or LR
		{
			if(height(root.left.left) > height(root.left.right))	//LL
				return rotateRight(root);
			
			else	//LR
			{
				root.left = rotateLeft(root.left);
				return rotateRight(root);
			}

		}
		
		if(balance < -1) //RR or RL
		{
			if(height(root.right.right) > height(root.right.left))	//RR
				return rotateLeft(root);
			
			else	//RL
			{
				root.right = rotateRight(root.right);
				return rotateLeft(root);
			}

		}
		
		return root;
	}

	public static void main(String args[]){
        AVLTree avlTree = new AVLTree();
        Node root = null;
        root = avlTree.insertAVLTree(root, -10);
        root = avlTree.insertAVLTree(root, 2);
        root = avlTree.insertAVLTree(root, 13);
        root = avlTree.insertAVLTree(root, -13);
        root = avlTree.insertAVLTree(root, -15);
        root = avlTree.insertAVLTree(root, 15);
        root = avlTree.insertAVLTree(root, 17);
        root = avlTree.insertAVLTree(root, 20);
        
        BST<Integer> tree = new BST();
        
        tree.inOrder(root);
        System.out.println();
        
        tree.preOrder(root);
        System.out.println();
        
        tree.postOrder(root);
    }

}
