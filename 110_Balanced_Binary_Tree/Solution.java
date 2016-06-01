/*
110. Balanced Binary Tree My Submissions QuestionEditorial Solution
Total Accepted: 113934 Total Submissions: 332370 Difficulty: Easy
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Subscribe to see which companies asked this question
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
        
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}