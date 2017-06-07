/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode prev = null;
		ListNode curr = head;
		
		while (curr != null) {
			ListNode tempNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tempNext;
		}
		
		return prev;
	}
}

public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = reverseList(head.next);
		
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
}