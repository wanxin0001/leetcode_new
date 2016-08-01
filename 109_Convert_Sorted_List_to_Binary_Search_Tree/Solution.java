/*
109. Convert Sorted List to Binary Search Tree  QuestionEditorial Solution  My Submissions
Total Accepted: 77116
Total Submissions: 245801
Difficulty: Medium
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 It uses global variable and create the tree from bottom to top. It is a good algorithm questions.
 */
public class Solution {
    private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        current = head;
        int size = getSize(head);
        
        return sortedListToBSTHelper(size);
    }
    
    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        } 
        
        return count;
    }
    
    private TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }
        
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - size / 2 - 1);
        root.left = left;
        root.right = right;
        
        return root;
    }
}