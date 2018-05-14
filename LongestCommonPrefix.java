class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
		// remember to check cornor case! if array is empty  loop will not end!
		if(strs.length == 0) return "";
        
        char lastChar = '\0';
        // current char index
		for (int p = 0;;p++) {
			// loop for each arr element
			for (int i = 0; i < strs.length; i++) {
                // check empty string
                // if (strs[i].length() == 0) return "";
                
				// if p is out side this string, just return this string. empty string also can be checked here
				if (p == strs[i].length()) {
					return strs[i];
				}
				// for each loop, set a compare character
				if (i == 0) lastChar = strs[0].charAt(p);
				// checkSet.add(strs[i].charAt(p));
				if (lastChar != strs[i].charAt(p)) {
					return strs[0].substring(0, p);
				}
			}
        }
    }
}