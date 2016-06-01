/*
102. Binary Tree Level Order Traversal My Submissions QuestionEditorial Solution
Total Accepted: 105841 Total Submissions: 319778 Difficulty: Easy
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (queue.size() != 0) { /*queue doesn't empty() method and queue needs to use linkedlist for implementation*/
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
            
            result.add(new ArrayList<Integer>(tmp));
        }
        
        return result;
    }
}