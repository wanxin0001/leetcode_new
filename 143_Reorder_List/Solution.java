/*
143. Reorder List  QuestionEditorial Solution  My Submissions
Total Accepted: 70114
Total Submissions: 298445
Difficulty: Medium
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode mid = getMid(head);
        ListNode rightNode = mid.next;
        mid.next = null;
        ListNode rightHead = reverse(rightNode);
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode right = rightHead;
        ListNode left = head;
        while(left != null || right != null) {
            if (left != null) {
                current.next = left;
                left = left.next;
                current = current.next;
            }
            
            if (right != null) {
                current.next = right;
                right = right.next;
                current = current.next;
            }
        }
        
        return;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        
        return pre;
    }
}