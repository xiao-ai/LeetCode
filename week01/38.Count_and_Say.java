public class Solution {
	public String countAndSay(int n) {
		if (n <= 0) {
            return null;
		}
        // initialize
        String result = "1";
        int i = 1;
        
		while (i < n) {
            StringBuilder s = new S.tringBuilder();
            int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
				} else {
                    s.append(count);
                    s.append(result.charAt(j - 1));
                    count = 1;
				}
			}
            s.append(count);
            s.append(result.charAt(result.length() - 1));
            result = s.toString();
            i++;
		}
        return result;
	}
}
