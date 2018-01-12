class Solution {
//	public static boolean isMatch(String text, String pattern) {
//		if (pattern.isEmpty()) return text.isEmpty();
//		boolean first_match = (!text.isEmpty() && 
//							   (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//		
//		if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
//			return (isMatch(text, pattern.substring(2)) || 
//					(first_match && isMatch(text.substring(1), pattern)));
//		} else {
//			return first_match && isMatch(text.substring(1), pattern.substring(1));
//		}
//	}
	
	public static boolean isMatch(String text, String pattern) {
		boolean[][] dp = new boolean[s.length() + 1][p.length + 1];
		dp[0][0] = true;
		
		// init
		for (int j = 1; j <= p.length(); j++) {
			if (j > 1 && p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				}
				
				if (p.charAt(j - 1) == '*') {
					// a* -> empty
					if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
						dp[i][j] = dp[i][j - 2];
					} else {
						// p matches multi
						// p matches single
						// p matches empty
						dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
					}
				}
			}
		}
		
		return dp[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
		String s = new String("abmmmm");
		String p = new String(".*");
		System.out.println(isMatch(s, p));
	}
}