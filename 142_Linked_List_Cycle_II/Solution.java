/*
142. Linked List Cycle II  QuestionEditorial Solution  My Submissions
Total Accepted: 82550
Total Submissions: 263937
Difficulty: Medium
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                return getNode(fast, slow);
            }
        }
        
        return null;
    }
    
    private ListNode getNode(ListNode fast, ListNode slow) {
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        
        return fast;
    }
}