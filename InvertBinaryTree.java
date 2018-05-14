public class InvertBinaryTree {
	// use level traversal, for each level, just swap children nodes of each root
	public TreeNode invertTree(TreeNode root) {
		// queue used to store level nodes
		Queue<TreeNode> level = new LinkedList<>();
		
		if (root != null) level.add(root);
		
		while(level.size() != 0) {
			// get a node
			TreeNode node = level.poll();
			
			// swap children nodes
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			// put next level nodes into queue
			if(node.left != null) level.add(node.left);
			if(node.right != null) level.add(node.right);
		}
		
		// root wont change
		return root;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode (int val) {this.val = val;}
}