/*
369. Plus One Linked List  QuestionEditorial Solution  My Submissions
Total Accepted: 2609
Total Submissions: 5203
Difficulty: Medium
Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
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
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode newHead = reverse(head);
        int count = 1;
        
        ListNode cur = newHead;
        while (cur != null) {
            int val = cur.val + count;
            count = val / 10;
            cur.val = val % 10;
            cur = cur.next;
        }
        
        newHead = reverse(newHead);
        if (count == 0) {
            return newHead;
        } else {
            ListNode dummy = new ListNode(1);
            dummy.next = newHead;
            return dummy;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
}