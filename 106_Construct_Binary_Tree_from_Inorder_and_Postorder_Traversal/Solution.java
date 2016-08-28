/*
106. Construct Binary Tree from Inorder and Postorder Traversal  QuestionEditorial Solution  My Submissions
Total Accepted: 63423
Total Submissions: 211231
Difficulty: Medium
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Show Company Tags
Hide Tags
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }   
        
        return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode myBuildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int pos = findPosition(inorder, inStart, inEnd, postorder[postEnd]);
        
        root.left = myBuildTree(inorder, inStart, pos - 1, postorder, postStart, pos - 1 - inStart + postStart);
        root.right = myBuildTree(inorder, pos + 1, inEnd, postorder, pos - inStart + postStart, postEnd - 1);
        
        return root;
    }
    
    private int findPosition(int[] inorder, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}