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
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.offer(root);
		
		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> arr = new ArrayList<>();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				arr.add(node.val);
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			res.add(arr);
		}
		return res;
	}
}