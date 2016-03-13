/*
Question:
35. Search Insert Position My Submissions Question
Total Accepted: 97373 Total Submissions: 263643 Difficulty: Medium
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0


Solution:
1. Check if the nums array is a normal array
2. if nums[0] >= target, return 0
   else nums[nums.length - 1] < target, return the array length.
   (Note: it is < rather than <=, because if nums[nums.length - 1] == target, it should return nums.lenght - 1)
3. after checking item2, we ensure nums[0] < target value <= nums[nums.length]
4. use binary search method to find mid
5. if mid's value doesn't equal to target, we need to check the value from left and right
we SHOULD first check if left's value == target, if yes, return left. Rather we just return right (because target is smaller or equal to right's value)

*/


public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums[0] >= target) {
            return 0;
        }
        
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] == target) {
            return left;
        } else {
            return right;
        }
        
    }
}