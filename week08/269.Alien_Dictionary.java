public class Solution {
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}
		
		Map<Character, Set<Character>> graph = new HashMap<>();
		int[] indegree = new int[26];
		Set<Character> dict = new HashSet<>();
		StringBuilder res = new StringBuilder();
		
		// save all chars in the words
		for (String word : words) {
			for (char c : word.toCharArray()) {
				dict.add(c);
			}
		}
		
		// build graph
		for (int i = 0; i < words.length - 1; i++) {
			char[] word1 = words[i].toCharArray();
			char[] word2 = words[i + 1].toCharArray();
			int len = Math.min(word1.length, word2.length);
			
			for (int j = 0; j < len; j++) {
				char c1 = word1[j];
				char c2 = word2[j];
				if (c1 != c2) {
					if (!graph.containsKey(c1)) {
						graph.put(c1, new HashSet<Character>());
					}
					if (graph.get(c1).add(c2)) {
						indegree[c2 - 'a']++;
					}
					break;
				}
			}
		}
		
		// enque all the chars with indegree of 0
		Deque<Character> queue = new ArrayDeque<>();
		for (char c : dict) {
			if (indegree[c - 'a'] == 0) {
				queue.offerLast(c);
			}
		}
		
		// BFS
		while (!queue.isEmpty()) {
			char cur = queue.pollFirst();
			res.append(cur);
			
			if (!graph.containsKey(cur)) {
				continue;
			}
			
			for (char next : graph.get(cur)) {
				if (--indegree[next - 'a'] == 0) {
					queue.offerLast(next);
				}
			}
		}
		
		return res.length() == dict.size() ? res.toString() : "";
	}
}