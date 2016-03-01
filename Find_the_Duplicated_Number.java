/*
287. Find the Duplicate Number My Submissions Question
Total Accepted: 21070 Total Submissions: 55534 Difficulty: Hard
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        
        int low = 1;
        int high = nums.length;
        
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                } 
            }
            
            if (count > mid) {
                high = mid;
            } else if (count < mid) {
                low = mid;
            } else {
                low = mid + 1;
            }
        }
        
        if (getDuplicate(low, nums)) {
            return low;
        } else if (getDuplicate(high, nums)) {
            return high;
        }
        
        return -1;
     
    }
    
    private boolean getDuplicate(int target, int[] A) {
        int count = 0;
        for (int i : A) {
            if (target == i) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}