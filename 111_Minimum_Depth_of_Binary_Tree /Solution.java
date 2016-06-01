/*
111. Minimum Depth of Binary Tree My Submissions QuestionEditorial Solution
Total Accepted: 108832 Total Submissions: 353075 Difficulty: Easy
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Subscribe to see which companies asked this question

Show Tags
Show Similar Problems

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1; // don't forget + 1
        } else if (root.right == null) {
            return minDepth(root.left) + 1; // don't forget + 1
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}