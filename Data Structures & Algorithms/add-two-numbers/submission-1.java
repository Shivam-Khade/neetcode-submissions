class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode mover = dummy;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int sum = carry;

            // Add value from first list if available.
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from second list if available.
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Create a node with the current digit.
            mover.next = new ListNode(sum % 10);

            // Update carry for the next iteration.
            carry = sum / 10;

            mover = mover.next;
        }

        // If a carry remains, add one final node.
        if (carry != 0) {
            mover.next = new ListNode(carry);
        }

        return dummy.next;
    }
}