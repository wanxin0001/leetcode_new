/*
129. Sum Root to Leaf Numbers My Submissions QuestionEditorial Solution
Total Accepted: 78629 Total Submissions: 237787 Difficulty: Medium
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root, list, 0);
        return sum(list);
    }
    
    private void helper(TreeNode node, ArrayList<Integer> list, int tmp) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            tmp = tmp * 10 + node.val;
            list.add(tmp);
            return;
        }
        
        helper(node.left, list, 10 * tmp + node.val);
        helper(node.right, list, 10 * tmp + node.val);
    }
    
    private int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        
        return sum;
    }
}