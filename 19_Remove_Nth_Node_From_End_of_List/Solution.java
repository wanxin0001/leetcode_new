/*
19. Remove Nth Node From End of List  QuestionEditorial Solution  My Submissions
Total Accepted: 120858
Total Submissions: 396694
Difficulty: Easy
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

Show Tags

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode right = dummy;
        ListNode left = dummy;
        while (n > 0) {
            right = right.next;
            n--;
        }
        
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        
        left.next = left.next.next;
        
        return dummy.next;
    }
}