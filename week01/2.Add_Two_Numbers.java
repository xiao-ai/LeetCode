/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		ListNode node1 = l1;
		ListNode node2 = l2;
		int carry = 0;
		
		while (node1 != null || node2 != null) {
			int x = node1 == null ? 0 : node1.val;
			int y = node2 == null ? 0 : node2.val;
			int sum = carry + x + y;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			
			if (node1 != null) {
				node1 = node1.next;
			}
			
			if (node2 != null) {
				node2 = node2.next;
			}
		}
		
		if (carry > 0) {
			cur.next = new ListNode(carry);
		}
		
		return dummy.next;
	}
}