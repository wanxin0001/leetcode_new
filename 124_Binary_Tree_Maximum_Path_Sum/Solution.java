/*
124. Binary Tree Maximum Path Sum My Submissions QuestionEditorial Solution
Total Accepted: 66449 Total Submissions: 281823 Difficulty: Hard
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    class NodeInfo {
        int maxVal;
        int singlePath;
        
        public NodeInfo(int maxVal, int singlePath) {
            this.maxVal = maxVal;
            this.singlePath = singlePath;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root).maxVal;
    }
    
    
    private NodeInfo helper(TreeNode root) {
        if (root == null) {
            return new NodeInfo(Integer.MIN_VALUE, 0);
        }
        
        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);
        
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0); // Very good point!!!
        
        int maxVal = Math.max(left.maxVal, right.maxVal);
        maxVal =  Math.max(left.singlePath + right.singlePath + root.val, maxVal);
       
        NodeInfo result = new NodeInfo(maxVal, singlePath);
        return result;
    }
}