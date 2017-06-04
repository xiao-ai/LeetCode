public class Solution {
	public int numDecodings(String s) {
		if (s.length() == 0 || s == null) {
			return 0;
		}

		int len = s.length();

		// dp[i] -> the number of decode ways from i to the last
		// dp[i] = 0, if s.charAt(i) == 0
		// dp[i] = dp[i + 1] + dp[i + 2], if s.charAt(i) < 26
		// dp[i] = dp[i + 1], if s.charAt(i) > 26
		int[] dp = new int[len + 1];
		dp[len] = 1;
		dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
		
		for (int i = len - 2 ; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				continue;
			}
			
			int cur = Integer.parseInt(s.substring(i, i + 2));
			
			if (cur > 26) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = dp[i + 1] + dp[i + 2];
			}
		}
		
		return dp[0];
	}
}