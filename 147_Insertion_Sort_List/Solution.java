/*
147. Insertion Sort List  QuestionEditorial Solution  My Submissions
Total Accepted: 77136
Total Submissions: 254417
Difficulty: Medium
Sort a linked list using insertion sort.

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            
            ListNode tmp = head.next;
            head.next = node.next; // It is not node.next.next;
            node.next = head;       
            head = tmp;
        }
        
        return dummy.next;
    }
}