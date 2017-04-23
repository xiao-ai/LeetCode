import java.util.*;

class Sorting {

	// O(n^2) unstable
	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			swap(arr, min, i);
		}
	}
	
	// O(n^2) stable
	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				}
			}
		}
	}
	
	// O(nlogn), space O(n), stable
	public void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			// devide
			int mid = start + (end - start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			
			// conquer
			merge(arr, start, mid, end);
		}
	}
	
	public void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		
		while (i <= start && j <= end) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= end) {
			temp[k++] = arr[j++];
		}
		
		// copy temp back to arr
		for (int k2 = 0; k2 < temp.length; k2++) {
			arr[start + k2] = temp[k2];
		}
	}
	
	// O(nlogn)
	public void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int partitionIndex = partition(arr, start, end);
			quickSort(arr, start, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}
	
	public int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int partitionIndex = start;
		
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				// swap arr[i] with arr[partitionIndex] if arr[i] < pivot
				swap(arr, i, partitionIndex);
				partitionIndex++;
			}
		}
		
		// swap pivot with element at partitionIndex after the for loop
		swap(arr, partitionIndex, end);
		return partitionIndex;
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		Sorting sort = new Sorting();
		int[] arr = {4, 2, 1, 3, 5};
		sort.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}