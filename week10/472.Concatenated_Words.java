public class Solution {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> res = new ArrayList<>();
		
		if (words == null || words.length == 0) {
			return res;
		}
		
		// sort the words by length
		Arrays.sort(words, (l, r) -> {
			return l.length() - r.length();
		});
		
		Set<String> dict = new HashSet<>();
		dict.add(words[0]);
		
		// run word break for each word
		for (int i = 1; i < words.length; i++) {
			if (wordBreak(words[i], dict)) {
				res.add(words[i]);
			}
			dict.add(words[i]);
		}
		
		return res;
	}
	
	private boolean wordBreak(String s, Set<String> dict) {
		if (s.length() == 0 || s == null) {
			return true;
		}
		
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[s.length()];
	}
}