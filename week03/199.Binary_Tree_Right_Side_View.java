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
	// iterative
	// public List<Integer> rightSideView(TreeNode root) {
	//     List<Integer> result = new ArrayList<>();
	//     if (root == null) {
	//         return result;
	//     }
		
	//     Queue<TreeNode> q = new ArrayDeque<TreeNode>();
	//     q.offer(root);
		
	//     while (!q.isEmpty()) {
	//         int size = q.size();
	//         for (int i = 0; i < size; i++) {
	//             TreeNode node = q.poll();
	//             if (i == size - 1) {
	//                 result.add(node.val);
	//             }
	//             if (node.left != null) {
	//                 q.offer(node.left);
	//             }
	//             if (node.right != null) {
	//                 q.offer(node.right);
	//             }
	//         }
	//     }
	//     return result;
	// }
	
	// recursive
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		helper(root, result, 0);
		return result;
	}
	
	private void helper(TreeNode node, List<Integer> result, int level) {
		if (node == null) {
			return;
		}
		if (result.size() == level) {
			result.add(node.val);
		}
		helper(node.right, result, level + 1);
		helper(node.left, result, level + 1);
	}
}