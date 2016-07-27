/*
366. Find Leaves of Binary Tree  QuestionEditorial Solution  My Submissions
Total Accepted: 2079
Total Submissions: 3932
Difficulty: Medium
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.left = root;
        while (dummyNode.left != null) {
            result.add(helper(dummyNode, root));
        }
        
        
        return result;
    }
    
    private List<Integer> helper(TreeNode parent, TreeNode current) {
       List<Integer> result = new ArrayList<Integer>();
       if (current.left == null && current.right == null) {
           if (parent.left == current) {
               parent.left = null;
           } else {
               parent.right = null;
           }
           
           result.add(current.val);
           return result;
       }
       
       if (current.left != null) {
           result.addAll(helper(current, current.left));
       }
       
       if (current.right != null) {
           result.addAll(helper(current, current.right));
       }
       
       return result;
    }
}