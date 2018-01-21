class Solution {
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int pivot = findPivot(nums);
		int m = nums.length;
		int start, end;

		if (target > nums[m - 1]) {
			start = 0;
			end = pivot;
		} else {
			start = pivot;
			end = m - 1;
		}
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			
			if (target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
	
	private static int findPivot(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		
		while (start < end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] > nums[end]) {
				// right
				start = mid + 1;
			} else if (nums[mid] < nums[end]) {
				// left
				end = mid;
			} else {
				end--;
			}
		}
		
		return start;
	}
	
	// solution 2
	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		
		while (start <= end){
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;
		
			if (nums[start] <= nums[mid]) {
				// nums[start..mid] is sorted
				// check if target in left half
				 if (nums[start] <= target && target < nums[mid]) { 
					end = mid - 1;
				 } else {
					start = mid + 1;
				 }
			} else {
				// nums[mid..end] is sorted
				// check if target in right half
				if (nums[mid] < target && target < nums[start]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = {1, 1, 3, 1};
		System.out.println(findPivot(a));
	}
}