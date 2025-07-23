/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){ // agr list empty hai ya sirf ek hi node hai, then cycle is not possible
            return false;
        }

        ListNode slow = head; // ek step se chlega
        ListNode fast = head; // 2 step se chlega ,, bcz agr cycle hua toh yeh toh match kr hi jayenge ek point pr aake

        while(fast != null && fast.next != null){ // jbb tk yeh dono null nhi hote tbb tk loop chle bcz agr yeh null ho gye mtlb cycle mil gya
            slow = slow.next;
            fast = fast.next.next; // movements of nodes by 1 and 2

            if(slow == fast){
                return true;
            }
        }
        return false; // and agr cycle nhi hai toh false kr de 
    }
}