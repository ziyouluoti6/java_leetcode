/*
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

public class TreeLevelTraveral {
	/*// recursive solution
	public List<List<Integer>> levelOrder(TreeNode root) {
        // init result, type can be inferred
		List<List<Integer>> result = new ArrayList<>();
		// tree traversal
		// for each level, we need keep level info in track, so level is a recursive parameter
		// same, result is not global data, should also be a parameter
		tltRecursive(root, 1, result);
		return result;
    }
	
	private void tltResursive(TreeNode node, int level, List<List<Integer>> result) {
		if (node == null) return;
		// new level
		if (level > result.size()) result.add(new ArrayList<>());
		// save value
		result.get(level - 1).add(node.val);
		// traverse next level
		tltRecursive(node.left, level + 1, result);
		tltRecursive(node.right, level + 1, result);
	}*/
	
	// iteratively
	public List<List<Integer>> levelOrder(TreeNode root) {
        // init result, type can be inferred
		List<List<Integer>> result = new ArrayList<>();
        // queue to save level nodes
        Queue<TreeNode> level = new LinkedList<>();
		// temp to queue to save next level nodes
		Queue<TreeNode> temp = new LinkedList<>();
        
		// tree traversal
		// for each level, we could use queue to save
		if (root != null)level.add(root);
        
		while (level.size() != 0) {
            List<Integer> levelResult = new ArrayList<>();

            while(level.size() != 0) {
                TreeNode node = level.poll();
                levelResult.add(node.val);
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            result.add(levelResult);

			// currently level is empty, temp is next level, so swap them
			Queue<TreeNode> swap = level;
			level = temp;
			temp = swap;
            // level = temp;
			// come on! this is reference!!!!!
			// temp.clear();
        }
        
		return result;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode (int val) {this.val = val;}
}