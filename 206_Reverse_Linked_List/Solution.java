/*
206. Reverse Linked List  QuestionEditorial Solution  My Submissions
Total Accepted: 127380
Total Submissions: 311532
Difficulty: Easy
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

Show Company Tags
Show Tags
Show Similar Problems

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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode current = head;
        ListNode prev = null;
        while (current != null) { // It is not current.next != null
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}