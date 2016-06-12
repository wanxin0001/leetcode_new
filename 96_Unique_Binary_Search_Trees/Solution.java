/*
96. Unique Binary Search Trees My Submissions QuestionEditorial Solution
Total Accepted: 85691 Total Submissions: 226576 Difficulty: Medium
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution {
    public int numTrees(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return 1;
        }
        
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += array[j] * array[i - j - 1];
            }
            array[i] = sum;
        }
        
        return array[n];
    }
}