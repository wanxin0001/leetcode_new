/*
235. Lowest Common Ancestor of a Binary Search Tree My Submissions QuestionEditorial Solution
Total Accepted: 73947 Total Submissions: 196774 Difficulty: Easy
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == null) {
            return q;
        }
        
        if (q == null) {
            return p;
        }
        
        
        if (hasNode(root, p) && hasNode(root, q)) {
            if (p.val <= q.val) {
                return helper(root, p, q);
            } else {
                return helper(root, q, p);
            }
        } else {
            return null;
        }
        
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && root.val <= q.val) {
            return root;
        } else if (p.val < root.val && q.val < root.val) {
            return helper(root.left, p, q);
        } else {
            return helper(root.right, p, q);
        }
    }
    
    private boolean hasNode(TreeNode root, TreeNode target) {
        TreeNode current = root;
        
        while(current != null) {
            if (current.val == target.val) {
                return true;
            } else if (current.val > target.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        return false;
    }
}