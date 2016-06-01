/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Recursion way
*/
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        postorderHelper(root, result);
        
        return result;
    }
    
    private void postorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        postorderHelper(root.left, result);
        postorderHelper(root.right, result);
        
        result.add(root.val);
    }
}

/*
Iterative way
*/

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode current = stack.peek();
            
            if (prev == null || current == prev.left || current == prev.right) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {
                result.add(current.val);
                stack.pop();
            }
            
            prev = current;
        }
        
        return result;
    }
}