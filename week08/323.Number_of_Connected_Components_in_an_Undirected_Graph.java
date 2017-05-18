// Union Find
public class Solution {
	public int countComponents(int n, int[][] edges) {
		int[] parents = new int[n];
		int count = n;

		// initialize
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int[] edge : edges) {
			int parentX = find(parents, edge[0]);
			int parentY = find(parents, edge[1]);
			
			if (parentX == parentY) {
				continue;
			}
			
			// union
			parents[parentX] = parentY;
			count--;
		}
		
		return count;
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
	public int countComponents(int n, int[][] edges) {
		// build graph
		List<List<Integer>> graph = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		// count the number of components using DFS
		boolean[] visited = new boolean[n];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfsHelper(graph, visited, i);
				count++;
			}
		}
		
		return count;
	}
	
	private void dfsHelper(List<List<Integer>> graph, boolean[] visited, int i) {
		for (int neighbor : graph.get(i)) {
			if (!visited[neighbor]) {
				visited[neighbor] = true;
				dfsHelper(graph, visited, neighbor);
			}
		}
	}
}