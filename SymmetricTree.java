public class SymmetricTree {
	
	/*// recursively
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
		
		return isSymmetric(root.left, root.right);
    }
	
	// overload function
	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		// both null is true
		if (left == null && right == null) return true;
		// if not both null, and either one is null then is false
		if (left == null || right == null) return false;
		// then compare value and children
		return left.val == right.val
		&& isSymmetric(left.left, right.right)
		&& isSymmetric(left.right, right.left);
	}*/
	
	// iteratively
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
		
		// why use stack?
		Stack<TreeNode> temp = new stack<>();
		temp.push(root.left);
		temp.push(root.right);
		
		while(!temp.empty()) {
			TreeNode p = temp.pop();
			TreeNode q = temp.pop();
			
			// continue, end this iteration, still need check other children nodes in temp
			if (p == null && q == null) continue; // jump out here
			if (p == null || q == null) return false;
			if (p.val != q.val) return false;
			
			temp.push(p.left);
			temp.push(q.right);
			
			temp.push(p.right);
			temp.push(q.left);
		}
		
		return true;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode (int val) {this.val = val;}
}