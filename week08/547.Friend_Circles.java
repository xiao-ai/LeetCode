// Union Find
public class Solution {
	public int findCircleNum(int[][] M) {
		int n = M.length;
		int counter = n;
		int[] parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if (i != j && M[i][j] == 1) {
					int parentX = find(parent, i);
					int parentY = find(parent, j);
					
					if (parentX == parentY) {
						continue;
					}

					// union
					parent[parentX] = parentY;
					counter--;
				}
			}
		}
		
		return counter;
	}
	
	private int find(int[] parent, int i) {
		while (parent[i] != i) {
			parent[i] = parent[parent[i]];
			i = parent[i];
		}

		return i;
	}
}