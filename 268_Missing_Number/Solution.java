/*
268. Missing Number  QuestionEditorial Solution  My Submissions
Total Accepted: 64723
Total Submissions: 155065
Difficulty: Medium
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int missingNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        if (min != 0) {
            return 0;
        }
        
        if (max != nums.length) {
            return nums.length;
        }
        
        int realSum = (min + max) * (nums.length + 1) / 2;
        
        return realSum - sum;
    }
}