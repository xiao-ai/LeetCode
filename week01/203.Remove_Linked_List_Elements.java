/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		
		if (head == null) {
			return head;
		}
		
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		
		return head;
	}
}

// recursive
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		
		head.next = removeElements(head.next, val);

		if (head.val == val) {
			return head.next;
		} else {
			return head;
		}
	}
}