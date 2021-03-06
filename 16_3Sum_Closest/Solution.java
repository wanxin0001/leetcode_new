/*
16. 3Sum Closest  QuestionEditorial Solution  My Submissions
Total Accepted: 89976
Total Submissions: 300419
Difficulty: Medium
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        long result = (long) Integer.MIN_VALUE;
        
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if ((long) Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return (int) result;
    }
}