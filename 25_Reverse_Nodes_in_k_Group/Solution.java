/*
25. Reverse Nodes in k-Group  QuestionEditorial Solution  My Submissions
Total Accepted: 65157
Total Submissions: 230044
Difficulty: Hard
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        
        List<ListNode> group = getGroup(head, k);
        List<ListNode> reversedGroup = reverse(group, k);
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        for (ListNode list : reversedGroup) {
            current.next = list;
            while(current.next != null) {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
    
    private List<ListNode> reverse(List<ListNode> group, int k) {
        List<ListNode> list = new ArrayList<ListNode>();
        for (ListNode head : group) {
            int count = 0;
            ListNode cur = head;
            while (cur != null) {
                count ++;
                cur = cur.next;
            }
            
            if (count == k) {
                ListNode pre = null;
                while(head != null) {
                    ListNode next = head.next;
                    head.next = pre;
                    pre = head;
                    head = next;
                }
                list.add(pre);
            } else {
                list.add(head);
            }
            
        }
        return list;
    }
    
    private List<ListNode> getGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode pre = head;
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            if (count == k) {
                count = 0;
                list.add(pre);
                pre = cur.next;
                cur.next = null;
                cur = pre;
            } else {
                 cur = cur.next;
            }
        }
        
        if (pre != null) {
            list.add(pre);
        }
        
        return list;
    }
}