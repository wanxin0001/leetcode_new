/*
272. Closest Binary Search Tree Value II  QuestionEditorial Solution  My Submissions
Total Accepted: 8757
Total Submissions: 24736
Difficulty: Hard
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Hint:

Consider implement these two helper functions:
getPredecessor(N), which returns the next smaller node to N.
getSuccessor(N), which returns the next larger node to N.
Try to assume that each node has a parent pointer, it makes the problem much easier.
Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
You would need two stacks to track the path in finding predecessor and successor node separately.
Hide Company Tags Google
Hide Tags Tree Stack
Hide Similar Problems (M) Binary Tree Inorder Traversal (E) Closest Binary Search Tree Value
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
Reference: https://discuss.leetcode.com/topic/22940/ac-clean-java-solution-using-two-stacks
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<Integer>();
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        
        while (k-- > 0) {
            if (s1.isEmpty()) {
                result.add(s2.pop());
            } else if (s2.isEmpty()) {
                result.add(s1.pop());
            } else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) {
                result.add(s1.pop());
            } else {
                result.add(s2.pop());
            }
        }
        
        return result;
    }
    
    private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        
        inorder(reverse ? root.right : root.left, target, reverse, stack);
        if ((reverse && root.val > target) || (!reverse && root.val <= target)) { //notice the order
            stack.push(root.val);
        }
        
        inorder(reverse ? root.left : root.right, target, reverse, stack);
    }
}