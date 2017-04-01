// insert in a sorted linkedlist
public ListNode insert(ListNode head, int val) {
	if (head == null) {
			ListNode newHead = new ListNode(val);
			return newHead;
	}

		ListNode cur = head;
		ListNode newNode = new ListNode(val);
		while (cur.next != null) {
			if (cur.next.val < val) {
				cur = cur.next;
			} else {
				ListNode next = cur.next;
				cur.next = newNode;
				newNode.next = next;
				return head;
			}
		}

		cur.next = newNode;
		return head;
}
