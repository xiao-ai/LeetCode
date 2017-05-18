// Union Find
public class Solution {
	public boolean validTree(int n, int[][] edges) {
		int[] parents = new int[n];
		
		// initialize the parents
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		for (int[] edge : edges) {
			int parentX = find(parents, edge[0]);
			int parentY = find(parents, edge[1]);
			
			if (parentX == parentY) {
				return false;
			}
			
			// union
			parents[parentX] = parentY;
		}
		
		return edges.length == n - 1;
	}
	
	private int find(int[] parents, int i) {
		while (parents[i] != i) {
			// path compression
			parents[i] = parents[parents[i]];
			i = parents[i];
		}
		
		return i;
	}
}

// DFS
public class Solution {
	public boolean validTree(int n, int[][] edges) {
		// build graph: ajacency list
		List<List<Integer>> graph = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		boolean[] visited = new boolean[n];
		
		// find circle
		if (containsCircle(graph, visited, 0, -1)) {
			return false;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		
		return true;
	}

	private boolean containsCircle(List<List<Integer>> graph, boolean[] visited, int cur, int pre) {
		if (visited[cur]) {
			return true;
		}
		
		visited[cur] = true;
		
		for (int vertex : graph.get(cur)) {
			if (vertex == pre) {
				continue;
			}
			if (containsCircle(graph, visited, vertex, cur)) {
				return true;
			}
		}

		return false;
	}
}

// BFS
public class Solution {
	public boolean validTree(int n, int[][] edges) {
		// build graph
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		// 0: never visited; 1, visited, not finished; 2, visited, finished
		int[] visited = new int[n];
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		queue.offerLast(0);
		visited[0] = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.pollFirst();
			
			for (int vertex : graph.get(cur)) {
				if (visited[vertex] == 1) {
					return false;
				}
				
				if (visited[vertex] == 2) {
					continue;
				}
				
				queue.offerLast(vertex);
				visited[vertex] = 1;
			}
			
			visited[cur] = 2;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				return false;
			}
		}
		
		return true;
	}
}