/*
300. Longest Increasing Subsequence  QuestionEditorial Solution  My Submissions
Total Accepted: 39482
Total Submissions: 110692
Difficulty: Medium
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.
*/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        
        int val = Integer.MIN_VALUE;
        for (int i = 0; i < f.length; i++) {
            val = Math.max(f[i], val);
        }
        
        return val;
    }
}