/*
92. Reverse Linked List II  QuestionEditorial Solution  My Submissions
Total Accepted: 78582
Total Submissions: 273899
Difficulty: Medium
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode firstTrail = getNode(dummy, m);
        ListNode secondTrail = firstTrail.next;
        ListNode secondHead = getNode(head, n);
        ListNode thirdHead = secondHead.next;
        firstTrail.next = null;
        secondHead.next = null;
        reverse(secondTrail);
        
        firstTrail.next = secondHead;
        secondTrail.next = thirdHead;
        
        return dummy.next;
    }
    
    private void reverse(ListNode node) {
        ListNode pre = null;
        ListNode current = node;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre= current;
            current = next;
        }
    }
    
    private ListNode getNode(ListNode head, int m) {
        ListNode current = head;
        while (--m != 0) {
            current = current.next;
        }
        
        return current;
    }
}