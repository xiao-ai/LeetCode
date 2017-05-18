public class Solution {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
			return new String();
		}
		
		// put all characters in t into map
		int[] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		
		int minLen = Integer.MAX_VALUE;
		int count = t.length();
		int start = 0;
		int startIndex = 0;
		int end = 0;
		char[] charS = s.toCharArray();
		
		while (end < charS.length) {
			if (map[charS[end]] > 0) {
				count--;
			}
			map[charS[end]]--;
			end++;
			
			while (count == 0) {
				if (end - start < minLen) {
					minLen = end - start;
					startIndex = start;
				}
				
				if (map[charS[start]] == 0) {
					count++;
				}
				map[charS[start]]++;
				start++;
			}
		}
		
		return minLen == Integer.MAX_VALUE ? new String() : new String(charS, startIndex, minLen);
	}
}