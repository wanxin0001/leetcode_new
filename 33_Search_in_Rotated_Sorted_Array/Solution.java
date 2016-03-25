/*
33. Search in Rotated Sorted Array My Submissions Question
Total Accepted: 95870 Total Submissions: 318526 Difficulty: Hard
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Solution:
1. check boundary condition
2. while loop
-- if mid value == target, return mid
-- if left < mid, it means [left, mid] range is non-descending order
--- if target is in this range, set right = mid. otherwise, set left = mid;
-- if mid < right, it means [mid, right] range is non-descending order
--- if target is in this range, set left = mid. Otherwise, set right = mid; 
*/


public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid]){
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (nums[left] == target) {
            return left;
        }
        
        if (nums[right] == target) {
            return right;
        }
        
        return -1;
    }
}