/*
298. Binary Tree Longest Consecutive Sequence My Submissions QuestionEditorial Solution
Total Accepted: 9157 Total Submissions: 24511 Difficulty: Medium
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
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
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return findLongest(root, 0, root.val - 1);
    }
    
    private int findLongest(TreeNode root, int length, int preVal) {
        if (root == null) {
            return length;
        }
        
        if (preVal + 1 == root.val) {
            length++;
        } else {
            length = 1;
        }
        
        return Math.max(length, Math.max(findLongest(root.left, length, root.val), findLongest(root.right, length, root.val)));
    }
}