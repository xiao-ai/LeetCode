public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y] != '.') {
					
					for (int k = 0; k < board.length; k++) {
						if (k != x && board[k][y] == board[x][y]) {
							return false;
						}
						if (k != y && board[x][k] == board[x][y]) {
							return false;
						}
					}
					
					int row = x / 3 * 3;
					int col = y / 3 * 3;
					
					for (int i = row; i < row + 3; i++) {
						for (int j = col; j < col + 3; j++) {
							if (i == x && j == y) {
								continue;
							}
							if (board[x][y] == board[i][j]) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
    }
}

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			Set<Character> rowSet = new HashSet<>();
			Set<Character> colSet = new HashSet<>();
			Set<Character> cubeSet = new HashSet<>();
			
			for (int j = 0; j < board[0].length; j++) {
				// row
				if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
					return false;
				}
				
				// col
				if (board[j][i] != '.' && !colSet.add(board[j][i])) {
					return false;
				}
				
				// cube
				int x = 3 * (i / 3) + j / 3;
				int y = 3 * (i % 3) + j % 3;
				if (board[x][y] != '.' && !cubeSet.add(board[x][y])) {
					return false;
				}
			}
		}
		return true;
	}
}