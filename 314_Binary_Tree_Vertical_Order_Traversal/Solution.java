/*
314. Binary Tree Vertical Order Traversal  QuestionEditorial Solution  My Submissions
Total Accepted: 8904
Total Submissions: 27290
Difficulty: Medium
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
Hide Company Tags Google Snapchat Facebook
Hide Tags Hash Table
Hide Similar Problems (E) Binary Tree Level Order Traversal

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        HashMap<Integer, ArrayList<Integer>> tmp = new HashMap<Integer, ArrayList<Integer>>();
        
        helper(root, tmp);
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : tmp.entrySet()) {
            int key = entry.getKey();
            min = Math.min(min, key);
            max = Math.max(max, key);
        }
        
        for (int i = min; i <= max; i++) {
            result.add(tmp.get(i));
        }
        
        return result;
    }
    
    private class MyNode {
        int idx;
        TreeNode treeNode;
        public MyNode(TreeNode treeNode, int idx) {
            this.idx = idx;
            this.treeNode = treeNode;
        }
    }
    private void helper(TreeNode root, HashMap<Integer, ArrayList<Integer>> map) {
        
        Queue<MyNode> queue = new LinkedList<MyNode>();
        queue.offer(new MyNode(root, 0));
        
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                MyNode cur = queue.poll();
                int idx = cur.idx;
                if (map.containsKey(idx)) {
                    map.get(idx).add(cur.treeNode.val);
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(cur.treeNode.val);
                    map.put(idx, list);
                }
                
                if (cur.treeNode.left != null) {
                    queue.offer(new MyNode(cur.treeNode.left, idx -1));
                }
                if (cur.treeNode.right != null) {
                    queue.offer(new MyNode(cur.treeNode.right, idx + 1));
                }
            }
            
        }
    }
}