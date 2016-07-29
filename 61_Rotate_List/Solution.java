/*
61. Rotate List  QuestionEditorial Solution  My Submissions
Total Accepted: 76106
Total Submissions: 326356
Difficulty: Medium
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int size = getSize(head);
        k = k % size;
        
        if (k == 0) { //necessary
            return head;
        }
        k = size - k;
        
        ListNode pre = getNode(head, k);
        ListNode newHead = pre.next;
        pre.next = null;
        ListNode end = newHead;
        while (end.next != null) {
            end = end.next;
        }
        end.next = head;
        
        return newHead;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            size++;
        }
        
        return size;
    }
    
    private ListNode getNode(ListNode head, int k) {
        ListNode current = head;
        while (--k != 0) {
            current = current.next;
        }
        
        return current;
    }
}