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
    public ListNode sortList(ListNode head) {
        // Base Case: If the list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head.next; // Start fast one step ahead to correctly split even-length lists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Split the list into two halves
        ListNode mid = slow.next;
        slow.next = null; // Break the link to separate the left half from the right half
        // Step 3: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        // Step 4: Merge the sorted halves
        return merge(left, right);
    }
    // Helper method to merge two sorted linked lists
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // Move the writer pointer forward
        }
        // Attach any remaining nodes from either list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }
}