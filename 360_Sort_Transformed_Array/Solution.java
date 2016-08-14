/*
360. Sort Transformed Array  QuestionEditorial Solution  My Submissions
Total Accepted: 2521
Total Submissions: 6183
Difficulty: Medium
Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.
*/
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            result[i] = a * x * x + b * x + c;
        }
        
        Arrays.sort(result);
        
        return result;
    }
}