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
        if (l1 == null) {
            return l2;
        }
                
        if (l2 == null) {
            return l1;
        }
                    
        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLists(l1, l2.next);
            return l2;
        }
	}
}
