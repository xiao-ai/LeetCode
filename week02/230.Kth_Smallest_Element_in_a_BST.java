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
	private int count;
	private int value;
	public int kthSmallest(TreeNode root, int k) {
		// if (root == null) {
		//     return -1;
		// }
		
		// Deque<TreeNode> stack = new ArrayDeque<>();
		// TreeNode cur = root;
		// while (cur != null) {
		//     stack.addFirst(cur);
		//     cur = cur.left;
		// }
		
		// while (!stack.isEmpty()) {
		//     cur = stack.removeFirst();
		//     k--;
			
		//     if (k == 0) {
		//         return cur.val;
		//     }
			
		//     cur = cur.right;
		//     while (cur != null) {
		//         stack.addFirst(cur);
		//         cur = cur.left;
		//     }
		// }
		
		// return -1;
		
		if (root == null) {
			return -1;
		}
		this.count = k;
		helper(root);
		return this.value;
	}
	
	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		
		helper(root.left);
		this.count--;
		
		if (this.count == 0) {
			this.value = root.val;
			return;
		}
		
		helper(root.right);
		return;
	}
}