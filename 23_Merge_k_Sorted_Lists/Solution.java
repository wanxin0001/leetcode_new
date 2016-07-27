/*
23. Merge k Sorted Lists  QuestionEditorial Solution  My Submissions
Total Accepted: 95180
Total Submissions: 392834
Difficulty: Hard
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Show Company Tags
Show Tags
Show Similar Problems

*/
/*
See http://www.jiuzhang.com/solutions/merge-k-sorted-lists/ for another good solution
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
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while(!heap.isEmpty()) {
            current.next = heap.poll();
            current = current.next;
            if (current.next != null) {
                heap.add(current.next);
            }
        }
        
        return dummy.next;
        
    }
    
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            } else {
                return left.val - right.val;
            }
        }
    };
    
}