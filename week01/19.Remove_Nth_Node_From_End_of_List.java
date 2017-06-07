    /**
 * Definition for singly-linked list.
 *public class ListNode {
 *	int val;
 *	ListNode next;
 *	ListNode(int x) { val = x;  }
 *}
 */

public class Solution {
	// public ListNode removeNthFromEnd(ListNode head, int n) {
	// 	if (head == null) {
	// 		return head;
	// 	}

    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = head;
    //     ListNode cur = dummy;

    //     int count = getCount(head);
    //     int start = 1;

	// 	while (start + n <= count) {
    //         cur = cur.next;
    //         start++;
    //     }

    //     cur.next = cur.next.next;
    //     return dummy.next;
	// }

	// private int getCount(ListNode head) {
	// 	if (head == null) {
    //         return 0;
	// 	}

    //     ListNode cur = head;
    //     int count = 1;
	// 	while (cur.next != null) {
    //         cur = cur.next;
    //         count++;
	// 	}
    //     return count;
	// }
	
	// a better one
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

		for (int i = 1; i <= n + 1; i++) {
            first = first.next;        
		}

		while (first != null) {
            first = first.next;
            second = second.next;        
		}

        second.next = second.next.next;
        return dummy.next;
	}
} 
