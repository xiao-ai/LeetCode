/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;

		while (true) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			cur = stack.pop();
			result.add(cur.val);
			cur = cur.right;
		}

		return result;
	}
}