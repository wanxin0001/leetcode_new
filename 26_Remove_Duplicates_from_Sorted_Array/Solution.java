/*
26. Remove Duplicates from Sorted Array  QuestionEditorial Solution  My Submissions
Total Accepted: 145587
Total Submissions: 425395
Difficulty: Easy
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int ptr = 0;
        int next = 0;
        while(next < nums.length) {
            while(next < nums.length - 1 && nums[next] == nums[next + 1]) {
                next++;
            }
            nums[ptr] = nums[next];
            ptr++;
            next++;
        }
        
        return ptr;
    }
}