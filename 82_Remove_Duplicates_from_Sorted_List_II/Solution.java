/*
82. Remove Duplicates from Sorted List II  QuestionEditorial Solution  My Submissions
Total Accepted: 79345
Total Submissions: 287841
Difficulty: Medium
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        
        //dummy.next = head;  Notice: it is very important to remove this.
        
        ListNode current = head;
        ListNode prev = dummy;
        while (current != null) {
            boolean flag = false;
            int val = current.val;
            ListNode next = current.next;
            while(next != null && next.val == val) {
                flag = true;
                next = next.next;
            }
            
            if (flag) {
                current = next;
                continue;
            } else {
                prev.next = current;
                prev = current;
                current = next;
                prev.next = null;
                
            }
        }
        
        return dummy.next;
    }
}