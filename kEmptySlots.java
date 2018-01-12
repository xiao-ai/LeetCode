import java.util.*;

// find size of k bloomed flowers

class Solution {
	public static int kEmptySlots(int[] flowers, int k) {
		int N = flowers.length;
		TreeSet<Integer> bloomed = new TreeSet();
		bloomed.add(0);
		bloomed.add(N + 1);
		int day = N;
		
		for (int i = N - 1; i >= 0; i--) {
			int flower = flowers[i];
			day--;
			bloomed.add(flower);
			Integer prev = bloomed.lower(flower);
			Integer next = bloomed.higher(flower);
			if (prev != null && flower - prev - 1 == k ||
				next != null && next - flower - 1 == k) {
					return day;
			}
		}
		
		return -1;
	}
		
	public static void main(String[] args) {
		int[] flowers = {3, 1, 5, 4, 2};
		System.out.print(kEmptySlots(flowers, 3));
	}
}