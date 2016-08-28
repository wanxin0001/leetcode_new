/*
137. Single Number II  QuestionEditorial Solution  My Submissions
Total Accepted: 93246
Total Submissions: 239828
Difficulty: Medium
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        
        int[] array = new int[32];
        
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    array[31 - i] += nums[j] & 1;
                    nums[j] = nums[j] >> 1;
                }
            }
            
            array[31 - i] %= 3;
        }
        
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            result = (result << 1) + array[i]; //rather than result << 1 + array[i]
        }
        
        return result;
    }
}