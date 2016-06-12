/*
113. Path Sum II My Submissions QuestionEditorial Solution
Total Accepted: 83740 Total Submissions: 292493 Difficulty: Medium
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        helper(root, sum, tmp, result);
        
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            tmp.add(root.val);
            if (isSumRight(sum, tmp)) {
                result.add(new ArrayList<Integer>(tmp));
            }
            tmp.remove(tmp.size() - 1);
            return;
        }
        
        tmp.add(root.val);
        helper(root.left, sum, tmp, result);
        helper(root.right, sum, tmp, result);
        tmp.remove(tmp.size() - 1);
        
    }
    
    private boolean isSumRight(int target, List<Integer> tmp) {
        int sum = 0;
        for (int i : tmp) {
            sum += i;
        }
        
        return sum == target;
    }
}