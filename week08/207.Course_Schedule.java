// DFS
public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// build graph
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int[] pair : prerequisites) {
			graph.get(pair[1]).add(pair[0]);
		}
		
		// find circle
		boolean[] visited = new boolean[numCourses];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < numCourses; i++) {
			if (set.contains(i)) {
				continue;
			}
			if (findCircle(graph, visited, set, i)) {
				return false;
			}
		}

		return true;
	}
	
	private boolean findCircle(List<List<Integer>> graph, boolean[] visited, Set<Integer> set, int pos) {
		if (visited[pos]) {
			return true;
		}
		
		visited[pos] = true;
		
		for (int next : graph.get(pos)) {
			if (findCircle(graph, visited, set, next)) {
				return true;
			}
		}
		
		visited[pos] = false;
		set.add(pos);
		return false;
	}
}

// BFS
public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites == null) {
			return true;
		}
		
		// build graph
		int[][] graph = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		
		for (int[] pair : prerequisites) {
			int pre = pair[1];
			int cur = pair[0];
			graph[pre][cur] = 1;
			indegree[cur]++;
		}
		
		Deque<Integer> queue = new ArrayDeque<>();
		int num = 0;
		
		// enqueue all courses with indegree of 0
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offerLast(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int curCourse = queue.pollFirst();
			num++;
			
			for (int i = 0; i < numCourses; i++) {
				if (graph[curCourse][i] == 1) {
					indegree[i]--;
					if (indegree[i] == 0) {
						queue.offerLast(i);
					}
				}
			}
		}
		
		return num == numCourses;
	}
}