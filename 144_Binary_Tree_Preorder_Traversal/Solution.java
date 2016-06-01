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
Iterative way (use a stack and insert right node first)
*/
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }
        
        stack.push(root);
        while(stack.size() != 0) {
            TreeNode current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        
        return result;
    }
}

/*
Recursion way
*/

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        preorderHelper(root, result);
        return result;
    }
    
    private void preorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        result.add(root.val);
        preorderHelper(root.left, result);
        preorderHelper(root.right, result);
    }
}