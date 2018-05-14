/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid. */

import java.util.Stack;

class ValidParentheses {
	
	public static void main (String[] args) {
		if (isValid("(){}[]")) {
			System.out.println("correct");
		} else {
			System.out.println("wrong");
		}
	}
	
	public static boolean isValid(String s) {
		Stack<Character> temp = new Stack<>();
		for (char ch : s.toCharArray()) {
			switch (ch) {
				case '(':
				case '[':
				case '{':
					temp.push(ch);
					// remember break !!!!!!
					break;
				case ')':
				case ']':
				case '}':
					if (temp.size() == 0) {
						return false;
					} else if (!isPair(ch, temp.pop())) {
						return false;
					}
					break;
			}
		}
		if (temp.size() != 0) return false;
		return true;
	}
	
	private static boolean isPair(char ch, char pop) {
		if (pop == '(' && ch == ')'
		|| pop == '[' && ch == ']'
	|| pop == '{' && ch == '}') {
		return true;
	} else {
		return false;
	}
	}
}