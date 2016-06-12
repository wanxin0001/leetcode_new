/*
173. Binary Search Tree Iterator My Submissions QuestionEditorial Solution
Total Accepted: 50488 Total Submissions: 143484 Difficulty: Medium
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
*/

/*
A very good problem, which uses global variable and stack to implement the iterator.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode current;
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    

    public BSTIterator(TreeNode root) {
        current = root;
      
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (current != null || !stack.isEmpty());
        
    }

    /** @return the next smallest number */
    public int next() {
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        TreeNode retval = current;
        current = current.right;
        
        return retval.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */