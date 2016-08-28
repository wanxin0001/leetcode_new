/*
333. Largest BST Subtree  QuestionEditorial Solution  My Submissions
Total Accepted: 6014
Total Submissions: 21472
Difficulty: Medium
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Hint:

You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?

Show Company Tags
Hide Tags Tree
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/36995/share-my-o-n-java-code-with-brief-explanation-and-comments/3
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
    class Result {
        int res;
        int min;
        int max;
        
        public Result(int res, int min, int max) {
            this.res = res;
            this.min = min;
            this.max = max;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        Result res = BSTSubtree(root);
        return Math.abs(res.res);
    }
    
    private Result BSTSubtree(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Result left = BSTSubtree(root.left);
        Result right = BSTSubtree(root.right);
        
        if (left.res < 0 || right.res < 0 || root.val < left.max || root.val > right.min) {
            return new Result(Math.max(Math.abs(left.res), Math.abs(right.res)) * (-1), 0, 0);
        } else {
            return new Result(left.res + right.res + 1,  Math.min(root.val, left.min), Math.max(root.val, right.max));
        }
        
    }
}