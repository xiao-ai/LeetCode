import java.util.*;

class Solution {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		Arrays.sort(coins);
		
		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] > i) {
					break;
				}
				if (dp[i - coins[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		if (dp[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[amount];
	}
	
	public int coinChangeDFS(int[] coins, int amount) {
		int[] count = new int[amount + 1];
		Arrays.fill(count, Integer.MAX_VALUE);
		Arrays.sort(coins);
		count[0] = 0;
		return helper(coins, amount, count);
	}
	
	private int helper(int[] coins, int remain, int[] count) {
		if (count[remain] != Integer.MAX_VALUE) {
			return count[remain];
		}

		for (int coin : coins) {
			if (remain >= coin) {
				int temp = helper(coins, remain - coin, count);
				if (temp != -1) {
					count[remain] = Math.min(count[remain], count[remain - coin] + 1);
				}
			}
		}

		return count[remain] == Integer.MAX_VALUE ? -1 : count[remain];
	}
}