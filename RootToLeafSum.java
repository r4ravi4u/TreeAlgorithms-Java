import java.util.*;

public class RootToLeafSum {

	static boolean rootToLeafSum(Node<Integer> root, int sum, List<Integer> result)
	{
		if(root == null)
			return false;
		
		if(root.left == null && root.right == null)
		{
			if(sum == root.data)
			{
				result.add(root.data);
				return true;
			}
			else
				return false;
		}
		
		if(rootToLeafSum(root.left, sum - root.data, result) || rootToLeafSum(root.right, sum - root.data, result))
		{
			result.add(root.data);
			return true;
		}
		/*if(rootToLeafSum(root.right, sum - root.data, result))
		{
			result.add(root.data);
			return true;
		}*/
		return false;
	}

}
