/*
112. Path Sum My Submissions QuestionEditorial Solution
Total Accepted: 106722 Total Submissions: 338251 Difficulty: Easy
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Show Company Tags
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return helper(root, sum, 0);
    }
    
    /*
    Notice: there is a special case: [1, 2] target = 1;    it means there is no left subnode. So, we cannot compare the target when node == null.
    */
    private boolean helper(TreeNode node, int sum, int tmp) {
        if (node.left == null && node.right == null) {
            if (sum == tmp + node.val) {
                return true;
            } else {
                return false;
            }
        }
        
        if (node.left != null && helper(node.left, sum, tmp + node.val)) {
            return true;
        }
        
        if (node.right != null && helper(node.right, sum, tmp + node.val)) {
            return true;
        }
        
        return false;
        
    }
}