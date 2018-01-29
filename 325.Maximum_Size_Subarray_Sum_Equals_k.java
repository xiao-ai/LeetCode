class Solution {
	public static void main(String[] args) {
		class Solution {
			public int maxSubArrayLen(int[] nums, int k) {
				// map<sum, i> -> the sum of all elements from index 0 to i
				Map<Integer, Integer> map = new HashMap<>();
				int max = 0;
				int sum = 0;
				
				for (int i = 0; i < nums.length; i++) {
					sum += nums[i];
					
					if (sum == k) {
						max = i + 1;
					} else if (map.containsKey(sum - k)) {
						max = Math.max(max, i - map.get(sum - k));
					}
					
					map.putIfAbsent(sum, i);
				}
				
				return max;
			}
		}
	}
}