/*
86. Partition List  QuestionEditorial Solution  My Submissions
Total Accepted: 72663
Total Submissions: 239591
Difficulty: Medium
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode dummyLeft = new ListNode(-1);
        ListNode dummyRight = new ListNode(-1);
        
        ListNode left = dummyLeft;
        ListNode right = dummyRight;
        
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;

            if (current.val >= x) {
                right.next = current;
                right = right.next;
            } else {
                left.next = current;
                left = left.next;
            }
            
            current = next;
        }
        
        current = dummy;
        if (dummyLeft.next != null) {
            current.next = dummyLeft.next;
            current = left;
        }
        
        if (dummyRight.next != null) {
            current.next = dummyRight.next;
            current = right;
        }
        
        current.next = null; //very necessary
        return dummy.next;
    }
}