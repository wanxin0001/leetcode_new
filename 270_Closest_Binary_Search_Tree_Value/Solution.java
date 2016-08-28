/*
270. Closest Binary Search Tree Value  QuestionEditorial Solution  My Submissions
Total Accepted: 16844
Total Submissions: 46945
Difficulty: Easy
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        double distance = Math.abs(root.val - target);
        int val;
        TreeNode cur = root;
        val = root.val;
        while(cur != null) {
            double tmp = Math.abs(cur.val - target);
            if (tmp <= distance) {
                distance = tmp;
                val = cur.val;
            }
            if (((double)cur.val) == target) {
                return cur.val;
            } else if (((double )cur.val) > target) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        
        
        return val;
    }
}