public class Solution {
	public int findRadius(int[] houses, int[] heaters) {
		int radius = 0;
		if (houses == null || heaters == null) {
			return radius;
		}
		
		int i = 0;
		int j = 0;
		Arrays.sort(houses);
		Arrays.sort(heaters);
		
		while (i < houses.length) {
			while (j < heaters.length - 1 && houses[i] - heaters[j] > heaters[j + 1] - houses[i]) {
				j++;
			}
			
			radius = Math.max(radius, Math.abs(heaters[j] - houses[i]));
			i++;
		}
		
		return radius;
	}
}