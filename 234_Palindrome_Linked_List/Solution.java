/*
234. Palindrome Linked List  QuestionEditorial Solution  My Submissions
Total Accepted: 58031
Total Submissions: 196133
Difficulty: Easy
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode rightHead = reverse(right);
        ListNode leftHead = head;
        while(leftHead != null && rightHead != null) {
            if (leftHead.val != rightHead.val) {
                return false;
            } 
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {  // It is not fast != null && fast.next != null
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}