/*
156. Binary Tree Upside Down My Submissions QuestionEditorial Solution
Total Accepted: 11144 Total Submissions: 28731 Difficulty: Medium
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode current = root;
        while (current != null) {
            list.add(0, current);
            current = current.left;
        }
        
        TreeNode newRoot = list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            TreeNode leaf = list.get(i + 1).right;
            list.get(i).left = leaf;
        }
        
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return newRoot;
    }
}