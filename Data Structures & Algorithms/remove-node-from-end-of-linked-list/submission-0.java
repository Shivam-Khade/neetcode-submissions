class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        // Move fast n steps ahead.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast is null, remove the first node.
        if (fast == null) {
            return head.next;
        }

        // Move both pointers.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Delete the target node.
        slow.next = slow.next.next;

        return head;
    }
}