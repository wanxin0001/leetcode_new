/*
280. Wiggle Sort  QuestionEditorial Solution  My Submissions
Total Accepted: 13953
Total Submissions: 27041
Difficulty: Medium
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
/*
Reference: https://discuss.leetcode.com/topic/23871/java-o-n-solution
*/
public class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) {
                    swap(nums, i, i - 1);
                }
            } else if (i != 0 && nums[i - 1] < nums[i]){
                swap(nums, i, i -1);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}