import java.util.*;

// https://leetcode.com/problems/permutations/#/description
// 46. Permutations
class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0 || nums == null) {
			return result;
		}
		
		permuteHelper(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
		
		return result;
	}
	
	private void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] isVisited) {
		// base case
		if (path.size() == nums.length) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			// current layer
			if (isVisited[i]) {
				continue;
			}
			path.add(nums[i]);
			isVisited[i] = true;
			
			// next layer
			permuteHelper(nums, result, path, isVisited);
			
			// current layer
			path.remove(path.size() - 1);
			isVisited[i] = false;
		}

		return;
	}
}