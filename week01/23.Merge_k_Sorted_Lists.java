/**
 * Definition for singly-linked list.
 * public class ListNode {
 * 		int val;
 * 		ListNode next;
 * 		ListNode(int x) { val = x;  }
 * }
 */

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
            return null;
		}
 
        return mergerHelper(lists, 0, lists.length - 1);
	}
 
	private ListNode mergerHelper(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];        
		}

        int mid = start + (end - start) / 2;
        ListNode left = mergerHelper(lists, start, mid);
        ListNode right = mergerHelper(lists, mid + 1, end);

        return mergeTwoLists(lists, left, right);    
	}
 
	private ListNode mergeTwoLists(ListNode[] lists, ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;       
			} else {
                head.next = l2;
                l2 = l2.next;
			}
            head = head.next;
		}
        
		if (l1 != null) {
            head.next = l1;
		}
        
		if (l2 != null) {
            head.next = l2;
		}
 
        return dummy.next;
	}
}
