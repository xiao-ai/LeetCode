public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (nums.length == 0 || nums == null) {
				return result;
			}
			Arrays.sort(nums);
			
			boolean[] isVisited = new boolean[nums.length];
			List<Integer> path = new ArrayList<Integer>();
			
			permuteHelper(nums, result, path, isVisited);
			
			return result;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] isVisited){
        // base case
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
			// current layer
			if (isVisited[i] || (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1])) {
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
    }
}