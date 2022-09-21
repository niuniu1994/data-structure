package leetcode;

import java.util.Stack;

public class solution {

	public boolean isValide(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '{'|| c=='[' || c=='(')
				stack.push(c);
			else {
				if(stack.isEmpty())
					return false;
				char c2 = stack.pop();
				if(c == '}' && c2 != '{')
					return false;
				if(c == ']' && c2 != '[')
					return false;
				if(c == ')' && c2 != '(')
					return false;
				}
			}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		solution x = new solution();
		
		System.out.println(x.isValide("(]"));
		
	}
}