import java.util.*;

class maxSlidingWindow {
	public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		
		for (int i = 0; i < nums.length - k + 1; i++) {
			result[i] = findMax(nums, k, i);
		}
		
		return result;
	}
	
	private static int findMax(int[] nums, int k, int i) {
		int max = Integer.MIN_VALUE;
		
		for (int j = i; j < k + i; j++) {
			max = nums[j] > max ? nums[j] : max;
		}
		
		return max;
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		
	}
	
	
	
	public static void main(String[] args) {
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] result = maxSlidingWindowBruteForce(nums, 3);
		System.out.print(Arrays.toString(result));
	}
}