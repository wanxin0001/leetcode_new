/*
2. Add Two Numbers  QuestionEditorial Solution  My Submissions
Total Accepted: 161556
Total Submissions: 667225
Difficulty: Medium
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(-1);
        int count = 0;
        ListNode current = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                count += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                count += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(count % 10);
            current = current.next;
            count = count / 10;
        }
        
        if (count != 0) {
            current.next = new ListNode(count);
        }
        
        return dummy.next;
    }
}