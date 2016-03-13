/*
Question:
154. Find Minimum in Rotated Sorted Array II My Submissions Question
Total Accepted: 47415 Total Submissions: 139451 Difficulty: Hard
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Answer:
1. check nums array's booundary
2. if nums[left] < nums[mid], 
        if nums[mid] <= nums[right],
            return nums[left];
        else
            left = mid
        end
    else if nums[left] > nums[mid]   (In this case, the smallest point must be in [left, mid])
        right = mid
    else
        left++
    end

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
                if (nums[mid] <= nums[right]) {
                    return nums[left];
                } else {
                    left = mid;
                }
            } else if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left++;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
    
}