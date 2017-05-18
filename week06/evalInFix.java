import java.util.*;

public class Solution {
	public int evalInFix(String[] tokens) {
		Deque<Integer> valStack = new ArrayDeque<>();
		Deque<String> opStack = new ArrayDeque<>();
			
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == "(") {
				opStack.offerLast(tokens[i]);
			} else if (tokens[i] == ")") {
				while (opStack.peekLast() != "(") {
					int val = calculate(opStack.pollLast(), valStack.pollLast(), valStack.pollLast());
					valStack.offerLast(val);
				}
				
				// poll "("
				opStack.pollLast();
			} else if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
				while (!opStack.isEmpty() && isLower(tokens[i], opStack.peekLast())) {
					int val = calculate(opStack.pollLast(), valStack.pollLast(), valStack.pollLast());
					valStack.offerLast(val);
				}
				
				// offer current op
				opStack.offerLast(tokens[i]);
			} else {
				valStack.offerLast(Integer.parseInt(tokens[i]));
			}
		}
		
		// calculate all remaining values in the stack
		while (!opStack.isEmpty()) {
			int val = calculate(opStack.pollLast(), valStack.pollLast(), valStack.pollLast());
			valStack.offerLast(val);
		}
		
		return valStack.pollLast();
	}

	private boolean isLower(String cur, String toPeek) {
		return (cur == "+" || cur == "-") && (cur == "*" || cur == "/");
	}
	
	private int cal(String op, int a, int b) {
		switch (op) {
			case "+": 
				return a + b;
			case "-": 
				return a - b;
			case "*": 
				return a * b;
			case "/": 
				return a / b;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] tokens = {"(", "6", "+", "2", ")", "*", "4"};
		System.out.print(solution.evalInFix(tokens));
	}
}