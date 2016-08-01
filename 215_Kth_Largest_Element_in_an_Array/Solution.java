/*
215. Kth Largest Element in an Array  QuestionEditorial Solution  My Submissions
Total Accepted: 67652
Total Submissions: 194877
Difficulty: Medium
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }
        
        k = nums.length - k + 1; // it needs to add 1.
        return helper(nums, 0, nums.length - 1, k);
    }
    
    private int helper(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        
        int position = partition(nums, left, right);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, right, k);
        } else {
            return helper(nums, left, position - 1, k);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int l = left, r = right;
        int pivot = nums[left];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        
        nums[l] = pivot;
        return l;
    }
}