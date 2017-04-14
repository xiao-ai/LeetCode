public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0 || nums == null) {
			return res;
		}

		subsetsHelper(res, new ArrayList<Integer>(), nums, 0);

		return res;
	}

	private void subsetsHelper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
		res.add(new ArrayList<Integer>(list));
		
		for (int i = pos; i < nums.length; i++) {
			list.add(nums[i]);
			subsetsHelper(res, list, nums, i + 1);
			list.remove(list.size() - 1);
		}

		return;
	}
}