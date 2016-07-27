/*
148. Sort List  QuestionEditorial Solution  My Submissions
Total Accepted: 77239
Total Submissions: 299862
Difficulty: Medium
Sort a linked list in O(n log n) time using constant space complexity.

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = getMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
    
    private ListNode getMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        
        if (right == null) {
            return left;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            
            current = current.next;
        }
        
        if (left != null) {
            current.next = left;
        }
        
        if (right != null) {
            current.next = right;
        }
        
        return dummy.next;
        
    }
}