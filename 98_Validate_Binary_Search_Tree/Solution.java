/*
98. Validate Binary Search Tree My Submissions QuestionEditorial Solution
Total Accepted: 95444 Total Submissions: 452858 Difficulty: Medium
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/
/*
* Use inorder tranversal way to solve the problem.
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
    
    private int lastVal = Integer.MIN_VALUE;
    private boolean isFirstNode = true;
    public boolean isValidBST(TreeNode root) {
       if (root == null) {
           return true;
       }
       
       if (!isValidBST(root.left)) {
           return false;
       } 
       
       if (!isFirstNode && root.val <= lastVal) {
           return false;
       }
       lastVal = root.val;
       isFirstNode = false;
       if (!isValidBST(root.right)) {
           return false;
       }
       
       
       return true;
    }
}


/*
Use divide and conquer way to solve the problem.
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
    
    class ResultType {
        boolean isBST;
        int maxValue;
        int minValue;
        
        ResultType(boolean isBST, int maxValue, int minValue) {
            this.isBST = isBST;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    
    
    public boolean isValidBST(TreeNode root) {
        ResultType result = validateHelper(root);
        return result.isBST;
    }
    
    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE); // rather than  ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE)
        }
        
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        
        if (!left.isBST || !right.isBST) {
            return new ResultType(false, 0, 0);
        }
        
        if (root.left != null && left.maxValue >= root.val || root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        
        return new ResultType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
    }
}