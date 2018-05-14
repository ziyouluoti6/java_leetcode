import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorder {
	public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
		traversalRecurse(root, result);
		
		return result;
    }
	
	private void traversalRecurse (TreeNode node, List<Integer> result) {
		if (node == null) return;
		
		traversalRecurse(node.left, result);
		result.add(node.val);
		traversalRecurse(node.right, result);
	}
}