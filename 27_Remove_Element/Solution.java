/*
27. Remove Element  QuestionEditorial Solution  My Submissions
Total Accepted: 132671
Total Submissions: 378575
Difficulty: Easy
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Hint:

Try two pointers.Show More Hint 
Show Tags
Show Similar Problems

*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int ptr = 0;
        int next = 0;
        int right = nums.length;
        while (next < right) {
            if (nums[ptr] == val) {
                change(nums, ptr, right - 1);
                right--;  //there is no next++;
            } else {
                nums[ptr] = nums[next];
                ptr++;
                next++;
            }
        }
        
        return right;
    }
    
    private void change(int[] num, int left, int right) {
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
    }
}