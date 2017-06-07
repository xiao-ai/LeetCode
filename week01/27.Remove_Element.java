public class Solution {
	public int removeElement(int[] nums, int val) {
		int index = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}
		}

		return index;
	}
}

public class Solution {
	public int removeElement(int[] nums, int val) {
		int i = 0;
		int pointer = nums.length - 1;
		while (i <= pointer) {
			if (nums[i] == val) {
				nums[i] = nums[pointer];
				pointer--;
			} else {
				i++;
			}
		}
		return pointer + 1;
	}
}
