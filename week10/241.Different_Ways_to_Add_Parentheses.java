public class Solution {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		
		if (input == null || input.length() == 0) {
			return res;
		}
		
		if (isDigit(input)) {
			res.add(Integer.parseInt(input));
			return res;
		}
		
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			
			if (!Character.isDigit(cur)) {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				
				if (cur == '+') {
					for (int l : left) {
						for (int r : right) {
							res.add(l + r);
						}
					}
				}
				
				if (cur == '-') {
					for (int l : left) {
						for (int r : right) {
							res.add(l - r);
						}
					}
				}
				
				if (cur == '*') {
					for (int l : left) {
						for (int r : right) {
							res.add(l * r);
						}
					}
				}
			}
		}
		
		return res;
	}
	
	private boolean isDigit(String input) {
		return input.matches("[0-9]+");
	}
}