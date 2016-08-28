/*
41. First Missing Positive  QuestionEditorial Solution  My Submissions
Total Accepted: 72521
Total Submissions: 297515
Difficulty: Hard
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

Hide Tags Array
Hide Similar Problems (M) Missing Number (H) Find the Duplicate Number
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
Reference: https://discuss.leetcode.com/topic/8293/my-short-c-solution-o-1-space-and-o-n-time
*/
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) { //rather than if
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}