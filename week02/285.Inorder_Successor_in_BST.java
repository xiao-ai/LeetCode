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
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		// base case
		// if (root == null) {
		//     return null;
		// }
		
		// if (p.val < root.val) {
		//     TreeNode left = inorderSuccessor(root.left, p);
		//     return left == null? root : left;
		// } else {
		//     return inorderSuccessor(root.right, p);
		// }

		if (root == null || p == null) {
			return root;
		}

		TreeNode suc = null;
		while (root != null) {
			if (root.val > p.val) {
				suc = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return suc;
	}
}