/*
117. Populating Next Right Pointers in Each Node II My Submissions QuestionEditorial Solution
Total Accepted: 63223 Total Submissions: 192145 Difficulty: Hard
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
Show Company Tags
Show Tags
Show Similar Problems

*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode lastNode = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                node.next = lastNode;
                lastNode = node;
            }
        }
        
        return;
    }
}