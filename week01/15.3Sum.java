public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		// sort the array
		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			// skip the duplicates
			if (i == 0 || nums[i] != nums[i - 1]) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						// skip the duplicates
						while (lo < hi && nums[lo] == nums[lo + 1]) {
							lo++;
						}
						while (lo < hi && nums[hi] == nums[hi - 1]) {
							hi--;
						}
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum) {
						lo++;
					} else {
						hi--;
					}
				}
			}
		}
		return result;
	}
}
