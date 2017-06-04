public class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		
		// dp[i] -> the longest increasing subsequence from 0 to i
		int[] dp = new int[nums.length];
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
		
		return max;
	}
}

// Binary Search
public class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		
		// dp[] -> increasing subsequence
		int[] dp = new int[nums.length];
		int res = 0;

		for (int cur : nums) {
			int index = Arrays.binarySearch(dp, 0, res, cur);
			if (index < 0) {
				index = -(index + 1);
			}
			
			dp[index] = cur;
			
			if (index == res) {
				res++;
			}
		}
		
		return res;
	}
}