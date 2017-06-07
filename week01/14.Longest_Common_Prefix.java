public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs == null) {
			return "";
		}

		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			while (j < prefix.length() && j < strs[i].length()) {
				if (prefix.charAt(j) == strs[i].charAt(j)) {
					j++;
				} else {
					break;
				}
			}
			if (j == 0) {
				return "";
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
}
