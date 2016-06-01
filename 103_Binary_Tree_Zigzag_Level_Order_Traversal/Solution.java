/*
103. Binary Tree Zigzag Level Order Traversal My Submissions QuestionEditorial Solution
Total Accepted: 62031 Total Submissions: 214238 Difficulty: Medium
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean startFromLeft = true;
        while (queue.size() != 0) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode current = queue.poll();
                if (startFromLeft) {
                    tmp.add(current.val);
                } else {
                    tmp.add(0, current.val);
                }
                
                if (current.left != null) {
                    queue.offer(current.left);
                } 
                
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            
            startFromLeft = !startFromLeft;
            result.add(new ArrayList<Integer>(tmp));
        }
        
        return result;
    }
}