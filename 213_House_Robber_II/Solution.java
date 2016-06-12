/*
213. House Robber II My Submissions QuestionEditorial Solution
Total Accepted: 30419 Total Submissions: 97756 Difficulty: Medium
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
*/

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        
        int optionOne = chooseFirstHouse(nums);
        int optionTwo = notChooseFirstHouse(nums);
        
        return Math.max(optionOne, optionTwo);
    }
    
    private int chooseFirstHouse(int[] nums) {
        int[] A = new int[nums.length];
        
        A[0] = nums[0];
        A[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length - 1; i++) {
            A[i] = Math.max(A[i - 1], A[i - 2] + nums[i]);
        }
        return A[nums.length - 2];
    }
    
    private int notChooseFirstHouse(int[] nums) {
        int[] A = new int[nums.length];
        A[0] = 0;
        A[1] = nums[1];
        
        for (int i = 2; i < nums.length; i++) {
            A[i] = Math.max(A[i - 1], A[i - 2] + nums[i]);
        }
        
        return A[nums.length -1];
    }
}