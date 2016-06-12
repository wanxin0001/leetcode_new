/*
199. Binary Tree Right Side View My Submissions QuestionEditorial Solution
Total Accepted: 44525 Total Submissions: 126124 Difficulty: Medium
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        helper(root, result, 0);
        return result;
    }
    
    private void helper(TreeNode node, List<Integer> result, int level) {
        if (node == null) {
            return;
        }
        
        if (result.size() == level) {
            result.add(node.val);
        }
        
       if (node.right != null) {
           helper(node.right, result, level + 1);
       }
       
       if (node.left != null) {
           helper(node.left, result, level + 1);
       }
    }
}