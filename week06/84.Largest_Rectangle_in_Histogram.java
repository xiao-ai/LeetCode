public class Solution {
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0 || heights == null) {
			return 0;
		}

		int max = 0;
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i <= heights.length; i++) {
			int cur;
			
			// Set curVal to the minimum value to guarantee the last elem
			// to be put into stack
			if (i == heights.length) {
				cur = 0;
			} else {
				cur = heights[i];
			}
			
			while (!stack.isEmpty() && heights[stack.peekLast()] >= cur) {
				int height = heights[stack.pollLast()];

				//Find left and right boundary from current rectangle
				int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;
				int right = i;
				max = Math.max(max, height * (right - left));
			}
			
			stack.offerLast(i);
		}
		
		return max;
	}
}