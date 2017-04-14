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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.offer(root);
		int count = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> arr = new ArrayList<Integer>();
			
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
			count += 1;
			if (count % 2 == 0) {
				Collections.reverse(arr);
			}
			res.add(arr);
		}
		return res;
	}
	
	// use boolean fromLeft and LinkedList
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.offer(root);
		boolean fromLeft = false;
		
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> arr = new LinkedList<Integer>();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (fromLeft) {
					arr.add(0, node.val);
				} else {
					arr.add(node.val);
				}
				
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			res.add(arr);
			fromLeft = !fromLeft;
		}
		return res;
	}
}