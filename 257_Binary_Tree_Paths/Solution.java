/*
257. Binary Tree Paths My Submissions QuestionEditorial Solution
Total Accepted: 50953 Total Submissions: 174283 Difficulty: Easy
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        
        if (root == null) {
            return result;
        }
        
        List<TreeNode> tmp = new ArrayList<TreeNode>();
        
        helper(root, tmp, result);
        
        return result;
    }
    
    private void helper(TreeNode node, List<TreeNode> tmp, List<String> result) {
        if (node.left == null && node.right == null) {
            tmp.add(node);
            result.add(processString(tmp));
            tmp.remove(tmp.size() - 1); //bug
            return;
        }
        
        tmp.add(node);
        if (node.left != null) {
            helper(node.left, tmp, result);
        }
        
        if (node.right != null) {
            helper(node.right, tmp, result);
        }
        
        tmp.remove(tmp.size() -1);
       
    }
    
    private String processString(List<TreeNode> nodeList) {
        String str = "" + nodeList.get(0).val;
        for (int i = 1; i < nodeList.size(); i++) {
            str += "->" + nodeList.get(i).val;
        }
        
        return str;
    }
}