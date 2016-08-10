/*
152. Maximum Product Subarray  QuestionEditorial Solution  My Submissions
Total Accepted: 67065
Total Submissions: 290832
Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
/*
Reference: https://discuss.leetcode.com/topic/3607/sharing-my-solution-o-1-space-o-n-running-time
*/
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxPre = nums[0];
        int minPre = nums[0];
        int maxVal = nums[0];
        int maxHere;
        int minHere;
        
        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(Math.max(maxPre * nums[i], minPre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxPre * nums[i], minPre * nums[i]), nums[i]);
            maxVal = Math.max(maxHere, maxVal); // rather than max(maxHere, minHere)
            minPre = minHere;
            maxPre = maxHere;
        }
        
        return maxVal;
    }
}