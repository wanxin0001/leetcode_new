/*
315. Count of Smaller Numbers After Self  QuestionEditorial Solution  My Submissions
Total Accepted: 14743
Total Submissions: 46341
Difficulty: Hard
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
/*
https://discuss.leetcode.com/topic/31405/9ms-short-java-bst-solution-get-answer-when-building-bst/7
*/
public class Solution {
    class Node{
        int val, leftSum = 0, count = 0;
        Node left, right;
        public Node(int val){
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        if(nums.length == 0){
            return Arrays.asList(count);
        }
        Node root = new Node(nums[nums.length - 1]);
        for(int i = nums.length - 1; i >= 0; i--){
            count[i] = insert(root, nums[i]);
        }
        return Arrays.asList(count);
    }
    private int insert(Node node, int num){
        int sum = 0;
        while(node.val != num){
            if(node.val > num){
                if(node.left == null) node.left = new Node(num);
                node.leftSum++;
                node = node.left;
            }else{
                sum += node.leftSum + node.count;
                if(node.right == null) node.right = new Node(num);
                node = node.right;
            }
        }
        node.count++;
        return sum + node.leftSum;
    }
}