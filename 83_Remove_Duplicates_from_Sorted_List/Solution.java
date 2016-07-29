/*
83. Remove Duplicates from Sorted List  QuestionEditorial Solution  My Submissions
Total Accepted: 129193
Total Submissions: 344474
Difficulty: Easy
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            while (next != null && current.val == next.val) {  // It is not if-statement
                next = next.next;
            }
            current.next = next;
            current = current.next;
        }
        
        return dummy.next;
    }
}