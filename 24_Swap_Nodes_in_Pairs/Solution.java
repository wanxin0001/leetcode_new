/*
24. Swap Nodes in Pairs  QuestionEditorial Solution  My Submissions
Total Accepted: 110584
Total Submissions: 307252
Difficulty: Easy
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; //It is not null;
        }
        
        ListNode firstHead = head;
        ListNode secondHead = head.next;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next != null) {
                current.next = next.next;
            }
            current = next;
        }
        
        ListNode dummy = new ListNode(-1);
        current = dummy;
        while (firstHead != null && secondHead != null) {
            current.next = secondHead;
            secondHead = secondHead.next;
            current = current.next;
            current.next = firstHead;
            firstHead = firstHead.next;
            current = current.next;
        }
        
        if (firstHead != null) {
            current.next = firstHead;
        }
        
        return dummy.next;
    }
}