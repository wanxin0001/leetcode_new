/*
81. Search in Rotated Sorted Array II My Submissions Question
Total Accepted: 59423 Total Submissions: 186680 Difficulty: Medium
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

Solution:
1. check boundary condition
2. while loop
-- if mid value == target, return mid
-- if left == mid, left++
-- if left < mid, it means [left, mid] range is non-descending order
--- if target is in this range, set right = mid. otherwise, set left = mid;
-- if mid < right, it means [mid, right] range is non-descending order
--- if target is in this range, set left = mid. Otherwise, set right = mid; 
-- if mid == right, right--
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]){
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                right--;
            }
        }
        
        if (nums[left] == target) {
            return true;
        }
        
        if (nums[right] == target) {
            return true;
        }
        
        return false;
    }
}