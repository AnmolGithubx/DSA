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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Step 2: Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from l1 and l2 or use 0 if null
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            // Create a new node with the digit part of sum
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move l1 and l2 to next nodes if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Step 3: Return the result list (skipping the dummy node)
        return dummy.next;
    }
}