import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
class BinarySearchTree {
	public TreeNode insert (TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		
		TreeNode cur = root;
		TreeNode prev = null;
		
		while (cur != null) {
			prev = cur;
			if (val < cur.val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		
		TreeNode newNode = new TreeNode(val);
		if (prev.val < val) {
			prev.right = newNode;
		} else {
			prev.left = newNode;
		}
		
		return root;
	}
	
	public void inTravRecur(TreeNode root) {
		if (root != null) {
			inTravRecur(root.left);
			System.out.print(root.val + " ");
			inTravRecur(root.right);
		}
	}
	
	public void preTravIter(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			System.out.print(cur.val + " ");
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	// O(logn)
	public void inTravIter(TreeNode root) {
		if (root == null) {
			return;
		}

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
			System.out.print(cur.val + " ");
			cur = cur.right;
		}
	}
	
	public void postTravIter(TreeNode root) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		Deque<TreeNode> output = new ArrayDeque<>();
		
		stack.push(root);
		TreeNode cur;
		
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
			cur = output.pop();
			System.out.print(cur.val + " ");
		}
	}
	
	public ArrayList<ArrayList<Integer>> levelOrderIter(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		
		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> arr = new ArrayList<>();
			TreeNode node;
			
			for (int i = 0; i < size; i++) {
				node = q.poll();
				arr.add(node.val);
				
				if (node.left != null) {
					q.offer(node.left);
				}
				
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			
			result.add(arr);
		}
		
		return result;
	}
	
	public int getNodeNumberRecur(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return getNodeNumberRecur(root.right) + getNodeNumberRecur(root.left) + 1;
	}
	
	public int getDepthRecur(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return Math.max(getDepthRecur(root.left), getDepthRecur(root.right)) + 1;
	}
	
	public int getDepthIter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		int depth = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			
			depth++;
		}
		return depth;
	}
	
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		
		if (root.val > max || root.val < min) {
			return false;
		}
		
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, node1, node2);
		TreeNode right = lowestCommonAncestor(root.right, node1, node2);
		
		if (left != null && right != null) {
			return root;
		} else if (left != null) {
			return left;
		} else {
			return right;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		TreeNode root = new TreeNode(4);
		tree.insert(root, 7);
		tree.insert(root, 6);
//		tree.insert(root, 1);
//		tree.insert(root, 3);
//		tree.insert(root, 5);
//		tree.insert(root, 7);
		
		System.out.println(tree.getNodeNumberRecur(root));
		System.out.println(tree.getDepthIter(root));
		tree.levelOrderIter(root);
		System.out.println(tree.isValidBST(root));
		
	}
}