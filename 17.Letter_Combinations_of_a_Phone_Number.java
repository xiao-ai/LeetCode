class Solution {
	private String[] map = {"0", "1",  "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		char[] temp = new char[digits.length()];
		
		if (digits == null || digits.length() == 0) {
			return result;
		}
		
		digitToLetters(digits, 0, temp, result);
		return result;
	}
	
	private void digitToLetters(String digits, int index, char[] temp, List<String> result) {
		if (index == digits.length()) {
			result.add(new String(temp));
			return;
		} else {
			for (int i = 0; i < map[digits.charAt(index) - '0'].length(); i++) {
				char c = map[digits.charAt(index) - '0'].charAt(i);
				temp[index] = c;
				digitToLetters(digits, index + 1, temp, result);
			}
		}
	}
}