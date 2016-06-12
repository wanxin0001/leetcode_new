/*
114. Flatten Binary Tree to Linked List My Submissions QuestionEditorial Solution
Total Accepted: 84732 Total Submissions: 270024 Difficulty: Medium
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

Show Company Tags
Show Tags

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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        preorder(root, list);
        
        reorder(list);
    }
    
    private void preorder(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) {
            return;
        }
        
        list.add(node);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    
    private void reorder(ArrayList<TreeNode> list) {
        TreeNode current = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            current.left = null;
            current.right = list.get(i);
            current = current.right;
        }
        
        current.left = null;
        current.right = null;
    }
    
    
}