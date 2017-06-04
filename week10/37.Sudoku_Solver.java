public class Solution {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		
		helper(board);
	}
	
	private boolean helper(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
							
							if (helper(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}

					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] board, int x, int y, char c) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][y] == c || board[x][i] == c) {
				return false;
			}
		}
		
		int row = x / 3 * 3;
		int col = y / 3 * 3;
		
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (board[i][j] == c) {
					return false;
				}
			}
		}
		
		return true;
	}
}