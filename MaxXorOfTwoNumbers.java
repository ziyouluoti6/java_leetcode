public class MaxXorOfTwoNumbers {
	public int findMaximumXOR(int[] nums) {
        // give initial value
		int max = 0, result = 0;
		TrieNode root = new TrieNode();
		
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) result = searchInTrieTree(root, num[i]);
			// update max, first one is no need
			max = Math.max(max, result);
			// last one no need insert
			if (i != nums.length - 1) insertIntoTrieTree(root, num[i]);
		}
    }
	
	// return max xor result for this input
	public int searchInTrieTree(TrieNode root, int input) {
		TrieNode cur = root;
		StringBuilder buidler = new StringBuilder();
		// use divide will get numbers from lsb, so better to use utility to convert
		String inputStr = Integer.toString(input, 2);
		
		while(input / 2 >= 0) {
			if (input % 2 == 1) {
				// try trace 0
				if(cur.zero != null) {
					builder.append("0")
					cur = cur.zero;
				} else {
					builder.append("1");
					cur = cur.one;
				}
			} else {
				// try trace 1
				if(cur.one != null) {
					builder.append("1")
					cur = cur.one;
				} else {
					builder.append("0");
					cur = cur.zero;
				}
			}
			// update input
			if(input / 2 == 0) {
				break;
			} else{
				input /= 2;
			}
		}
		
		return Integer.parse(builder.toString());
	}
	
	// inert current number into trie tree
	public void insertIntoTrieTree(TrieNode root, int input) {
		TrieNode cur = root;
		while(input/2 >= 0) {
			if (input % 2 == 1) {
				// just insert as it is
				cur.one = new TrieNode();
				cur = cur.one;
			} else {
				cur.zero = new TrieNode();
				cur = cur.zero;
			}
			// update input
			if (input == 1) break;
			input /= 2;
		}
	}
}

class TrieNode {
	public TrieNode zero;
	public TrieNode one;
	
	TrieNode() {}
}