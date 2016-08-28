/*
209. Minimum Size Subarray Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 48352
Total Submissions: 174317
Difficulty: Medium
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0, end = 0, len = Integer.MAX_VALUE;
        int sum = 0;
        int length = nums.length;
        while (end < length) {
            sum += nums[end];
            end++;
            
            while (sum >= s) {
                len = Math.min(len, end - start);
                sum -= nums[start];
                start++;
            }
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
        
    }
}