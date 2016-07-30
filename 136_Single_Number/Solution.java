/*
136. Single Number  QuestionEditorial Solution  My Submissions
Total Accepted: 140851
Total Submissions: 276190
Difficulty: Medium
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            val = val ^ nums[i];
        }
        
        return val;
    }
}