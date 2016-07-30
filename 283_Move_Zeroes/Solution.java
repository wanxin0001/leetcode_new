/*
283. Move Zeroes  QuestionEditorial Solution  My Submissions
Total Accepted: 101940
Total Submissions: 223859
Difficulty: Easy
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int pointer = 0;
        int next = 0;
        int right = 0;
        while (next < nums.length) {
            if (nums[next] != 0) {
                nums[pointer] = nums[next];
                pointer++;
                next++;
            } else {
                next++;
                right++;
            }
        }
        
        for (int i = 0; i < right; i++) {
            nums[nums.length - 1 - i] = 0;
        }
        
        return;
    }
}