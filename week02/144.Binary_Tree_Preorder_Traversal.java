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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		stack.push(cur);

		while (!stack.isEmpty()) {
			cur = stack.pop();
			result.add(cur.val);

			if (cur.right != null) {
				stack.push(cur.right);
			}

			if (cur.left != null) {
				stack.push(cur.left);
			}
		}

		return result;
	}
}