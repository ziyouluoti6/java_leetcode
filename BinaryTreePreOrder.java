public class BinaryTreePreOrder {
	public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
		traversalRecurse(root, result);
		
		return result;
    }
	
	private void traversalRecurse (TreeNode node, List<Integer> result) {
		if (node == null) return;
		
		result.add(node.val);
		
		traversalRecurse(node.left, result);
		traversalRecurse(node.right, result);
	}
}