/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}
		
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return dfsHelper(node, map);
	}
	
	private UndirectedGraphNode dfsHelper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		// create new node
		map.put(node, new UndirectedGraphNode(node.label));
		
		// traverse
		for (UndirectedGraphNode nei : node.neighbors) {
			if (!map.containsKey(nei)) {
				dfsHelper(nei, map);
			}
			
			// connect
			map.get(node).neighbors.add(map.get(nei));
		}
		
		return map.get(node);
	}
}


// BFS
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}
		
		Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		
		queue.offerLast(node);
		map.put(node, new UndirectedGraphNode(node.label));
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.pollFirst();
			UndirectedGraphNode copy = map.get(cur);
			
			for (UndirectedGraphNode nei : cur.neighbors) {
				if (!map.containsKey(nei)) {
					queue.offerLast(nei);
					map.put(nei, new UndirectedGraphNode(nei.label));
				}
				
				copy.neighbors.add(map.get(nei));
			}
		}
		
		return map.get(node);
	}
}