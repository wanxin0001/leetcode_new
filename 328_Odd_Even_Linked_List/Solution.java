/*
328. Odd Even Linked List  QuestionEditorial Solution  My Submissions
Total Accepted: 38782
Total Submissions: 97505
Difficulty: Medium
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

Credits:
Special thanks to @DjangoUnchained for adding this problem and creating all test cases.
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode firstHead = head;
        ListNode secondHead = head.next;
        
        ListNode current = head;
        
        while(current != null) {
            ListNode next = current.next;
            if (next != null) {
                current.next = next.next;
            }
            
            current = next;
        }
        
        current = firstHead;
        while (current.next != null) {
            current = current.next;   
        }
        
        current.next = secondHead;
        
        return firstHead;
    }
}