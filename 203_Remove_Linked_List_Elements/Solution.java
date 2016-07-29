/*
203. Remove Linked List Elements  QuestionEditorial Solution  My Submissions
Total Accepted: 73093
Total Submissions: 246646
Difficulty: Easy
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode current = head;
        
        while(current != null) {
            ListNode next = current.next;  //write in this way
            if (current.val != val) {
                pre.next = current;
                pre = pre.next;
                pre.next = null; //necessary
            }
            current = next;  //write in this way
        }
        
        return dummy.next;
    }
}