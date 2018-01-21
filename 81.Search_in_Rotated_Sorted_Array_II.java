class Solution {
	public boolean search(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)  {
				return true; 
			}
			if (nums[start] < nums[mid]) { 
				// nums[start..mid] is sorted
				// check if target in left half
				if (nums[start] <= target && target < nums[mid]) {
					end = mid - 1; 
				} else {
					start = mid + 1;
				}
			} else if (nums[mid] < nums[start]) {
				// nums[mid..end] is sorted
				// check if target in right half
				if (nums[mid] < target && target < nums[start]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else { 
				// have no idea about the array,
				// but we can exclude nums[start] 
				// because nums[start] == nums[mid]
				start++;
			}
		}
		return false;
	}
}