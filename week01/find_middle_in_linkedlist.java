// find middle in linkedlist
public ListNode findMiddle(ListNode head) {
		int count = getCount(head);
		int i = 0;
		ListNode cur = head;
		while (i < count / 2) {
			i++;
			cur = cur.next;
		
		}
		return cur;
	
}

public int getCount(ListNode head) {
	if (head == null) {
			return 0;
		
	}

		ListNode cur = head;
		int count = 1;
		while (cur.next != null) {
			cur = cur.next;
			count++;
		
		}
		return count;
	
}
