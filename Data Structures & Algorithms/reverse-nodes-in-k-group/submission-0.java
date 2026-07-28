/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt = 0;
        ListNode mover = head;

        while (mover != null && cnt < k) {
            mover = mover.next;
            cnt++;
        }

        if (cnt < k) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
