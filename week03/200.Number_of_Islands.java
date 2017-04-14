public class Solution {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					continue;
				}
				helper(grid, i, j);
				count += 1;
			}
		}
		return count;
	}
	
	private void helper(char[][] grid, int x, int y) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
			return;
		}
		grid[x][y] = '0';
		helper(grid, x - 1, y);
		helper(grid, x + 1, y);
		helper(grid, x, y - 1);
		helper(grid, x, y + 1);
		return;
	}
}