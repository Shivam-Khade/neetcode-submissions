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
    public void reorderList(ListNode head) {

        // If the list has 0 or 1 node, no reordering is needed.
        if (head == null || head.next == null) {
            return;
        }

        // -----------------------------
        // Step 1: Find the middle node
        // -----------------------------
        ListNode slow = head;
        ListNode fast = head;

        // Slow moves 1 step, Fast moves 2 steps.
        // When fast reaches the end, slow is at the middle.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // -----------------------------
        // Step 2: Reverse second half
        // -----------------------------
        ListNode second = reverse(slow.next);

        // Break the list into two halves.
        slow.next = null;

        // -----------------------------
        // Step 3: Merge alternately
        // -----------------------------
        ListNode first = head;

        while (second != null) {

            // Save next nodes before changing links.
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Merge one node from first half
            // then one node from second half.
            first.next = second;
            second.next = temp1;

            // Move both pointers forward.
            first = temp1;
            second = temp2;
        }
    }

    // Reverses a linked list and returns the new head.
    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {

            // Store next node.
            ListNode next = head.next;

            // Reverse current node's pointer.
            head.next = prev;

            // Move pointers forward.
            prev = head;
            head = next;
        }

        // 'prev' is the new head of the reversed list.
        return prev;
    }
}