/*
107. Binary Tree Level Order Traversal II My Submissions QuestionEditorial Solution
Total Accepted: 82444 Total Submissions: 240994 Difficulty: Easy
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Subscribe to see which companies asked this question
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (queue.size() != 0) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                tmp.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                } 
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            
            result.add(0, new ArrayList<Integer>(tmp));
        }
        
        return result;
    }
}