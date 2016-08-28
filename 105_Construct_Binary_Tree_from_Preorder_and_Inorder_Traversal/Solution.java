/*
105. Construct Binary Tree from Preorder and Inorder Traversal  QuestionEditorial Solution  My Submissions
Total Accepted: 73320
Total Submissions: 246329
Difficulty: Medium
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Hide Company Tags Bloomberg
Hide Tags Tree Array Depth-first Search
Hide Similar Problems (M) Construct Binary Tree from Inorder and Postorder Traversal
Have you met this question in a real interview? Yes  
*/
/*
Reference: 
http://www.jiuzhang.com/solutions/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    
    private TreeNode myBuildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = findPosition(inorder, inStart, inEnd, root.val);
        
        root.left = myBuildTree(inorder, inStart, pos - 1, preorder, preStart + 1, preStart - inStart + pos);
        root.right = myBuildTree(inorder, pos + 1, inEnd, preorder, preStart - inStart + pos + 1, preEnd);
        
        return root;
    }
    
    private int findPosition(int[] inorder, int inStart, int inEnd, int target) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}