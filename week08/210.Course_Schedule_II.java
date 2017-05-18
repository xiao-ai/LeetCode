public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// build graph: adjacency matrix
		int[][] graph = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];

		for (int[] pair : prerequisites) {
			int pre = pair[1];
			int cur = pair[0];
			graph[pre][cur] = 1;
			indegree[cur]++;
		}
		
		Deque<Integer> queue = new ArrayDeque<>();
		int index = 0;
		int[] result = new int[numCourses];
		
		// enque all vertices with indegree of 0
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offerLast(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int curCourse = queue.pollFirst();
			result[index++] = curCourse;i
			
			for (int i = 0; i < numCourses; i++) {
				if (graph[curCourse][i] == 1) {
					indegree[i]--;
					if (indegree[i] == 0) {
						queue.offerLast(i);
					}
				}
			}
		}
		
		return index == numCourses ? result : new int[0];
	}
}