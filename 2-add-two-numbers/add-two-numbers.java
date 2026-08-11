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
        // Create a dummy head to simplify list construction
        ListNode dummyHead = new ListNode(0);
        ListNode current= dummyHead;
        int carry = 0;
        
        // Traverse both lists or until the carry is resolved
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Calculate total sum and update carry
            int totalSum = val1 + val2 + carry;
            carry = totalSum / 10;
            
            // Create a new node for the current digit and attach it
            current.next = new ListNode(totalSum % 10);
            current = current.next;
            
            // Move to the next nodes in l1 and l2 if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // Return the actual head of the result list
        return dummyHead.next;
    }
}