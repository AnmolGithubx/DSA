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

        int length = 0;
        ListNode temp = head;
        while ( temp != null ){
            length++;
            temp = temp.next;
        }

        if(k<=1 || k>length || head == null){
            return head;
        }


        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while (length >= k) {
            ListNode groupStart = current;
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            prevGroupEnd.next = prev;
            groupStart.next = current;

            prevGroupEnd = groupStart;
            length -= k;
        }

        return dummy.next;
    }
}