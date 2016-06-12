/*
222. Count Complete Tree Nodes My Submissions QuestionEditorial Solution
Total Accepted: 35045 Total Submissions: 137193 Difficulty: Medium
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
*/

/*
This is a goode binary tree algorithm problem.
when left is full, add all left count and check right subtree;
when right is full, add all right count and check left subtree;
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = leftHeight(root.left);
        int right = leftHeight(root.right);
        
        
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        }
        
        return countNodes(root.left) + (1 << right);
    }
    
    private int leftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        
        return height;
    }
}