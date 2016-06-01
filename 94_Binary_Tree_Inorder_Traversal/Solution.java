/*
94. Binary Tree Inorder Traversal My Submissions QuestionEditorial Solution
Total Accepted: 127198 Total Submissions: 317827 Difficulty: Medium
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Subscribe to see which companies asked this question
*/


/*
 *    Iterative way
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result; /*do not miss return statement*/
    }
}


/*
Iterative way
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.peek();
            result.add(current.val);
            stack.pop();
            current = current.right;
        }
        
        return result;
    }
}