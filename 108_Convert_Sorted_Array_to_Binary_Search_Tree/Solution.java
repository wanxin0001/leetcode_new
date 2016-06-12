/*
108. Convert Sorted Array to Binary Search Tree My Submissions QuestionEditorial Solution
Total Accepted: 78389 Total Submissions: 207671 Difficulty: Medium
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode leftNode = helper(nums, left, mid - 1);
        TreeNode rightNode = helper(nums, mid + 1, right);
        
        TreeNode current = new TreeNode(nums[mid]);
        current.left = leftNode;
        current.right = rightNode;
        
        return current;
    }
}