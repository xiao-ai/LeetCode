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
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
		if (root == null) {
            return result;
		}
 
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> output = new ArrayDeque<>();
        
        TreeNode cur = root;
        stack.push(cur);
        
		while (!stack.isEmpty()) {
            cur = stack.pop();
            output.push(cur);
            
			if (cur.left != null) {
                stack.push(cur.left);
			}
 
			if (cur.right != null) {
                stack.push(cur.right);
			}
		}
        
		while (!output.isEmpty()) {
            result.add(output.pop().val);
		}
        return result;
	}
}
