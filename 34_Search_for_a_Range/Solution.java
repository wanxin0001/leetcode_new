/*
34. Search for a Range My Submissions Question
Total Accepted: 77778 Total Submissions: 269068 Difficulty: Medium
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


Solution:
1. find the leftmost index;
2. find the rightmost index;
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int left = getIndex(nums, target, true);
        int right;
        if (left == -1) {
            return result;
        } else {
            right = getIndex(nums, target, false);
        }
        
        result[0] = left;
        result[1] = right;
        
        return result;
    }
    
    private int getIndex(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (isLeft) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (isLeft) {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } 
        } else {
            if (nums[right] == target) {
                return right;
            } else if (nums[left] == target) {
                return left;
            }
        }
        
        return -1;
    }
}