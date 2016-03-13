/*
Questions:
153. Find Minimum in Rotated Sorted Array My Submissions Question
Total Accepted: 83894 Total Submissions: 234733 Difficulty: Medium
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Solution:
1. check nums array's boundary.
2.  if nums[left] < nums[mid]:
        if nums[mid] < nums[right], return nums[left];
        else, left = mid;
    else
        right = mid
    end
3. find the the smaller value in left or right.

Notice: the retural val is the value of the position, rather than the position.

*/


public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                if (nums[mid] < nums[right]) {
                    return nums[left];
                } else {
                    left = mid;
                }
            } else {
                right = mid;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}