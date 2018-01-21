import java.util.*;

class Solution {
	public static void main(String[] args) {
		int[] nums1 = {4, 6, 9};
		int[] nums2 = {3, 5, 8};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
		int n = nums2.length;
		
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		
		int iMin = 0;
		int iMax = m;
		
		while (iMin < iMax) {
			// i + j = m - i + n - j
			// i + j = (m + n) / 2
			int i = iMin + (iMax - iMin) / 2;
			int j = (m + n + 1) / 2 - i;
			
			int nums1Left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
			int nums1Right = i == m ? Integer.MAX_VALUE : nums1[i];
			int nums2Left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
			int nums2Right = j == n ? Integer.MAX_VALUE : nums2[j];
			
			if (nums1Left > nums2Right) {
				iMax = iMax - 1;
			} else if (nums2Left > nums1Right) {
				iMin = iMin + 1;
			} else {
				int maxLeft = Math.max(nums1Left, nums2Left);
				int minRight = Math.min(nums1Right, nums2Right);
				if ((m + n) % 2 == 1) 
					return maxLeft;
				else 
					return (maxLeft + minRight) / 2.0;
			}
		}

		return 0.0;
    }

	
	
//	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//		int m = nums1.length;
//		int n = nums2.length;
//		int[] arr = new int[m + n];
//		
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		while (i < m && j < n) {
//			if (nums1[i] < nums2[j]) {
//				arr[k++] = nums1[i++];
//			} else {
//				arr[k++] = nums2[j++];
//			}
//		}
//		
//		while (i < m) {
//			arr[k++] = nums1[i++];
//		}
//		
//		while (j < n) {
//			arr[k++] = nums2[j++];
//		}
//		
//		int mid = (m + n) / 2;
//		if ((m + n) % 2 == 1) {
//			return arr[mid];
//		} else {
//			return (arr[mid - 1] + arr[mid]) / 2.0;
//		}
//	}
}