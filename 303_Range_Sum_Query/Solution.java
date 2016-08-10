/*
303. Range Sum Query - Immutable  QuestionEditorial Solution  My Submissions
Total Accepted: 39183
Total Submissions: 153030
Difficulty: Easy
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
Show Company Tags
Show Tags
Show Similar Problems

*/
public class NumArray {

    private int[] f;
    public NumArray(int[] nums) {
        f = new int[nums.length];
        for (int i = 0; i < f.length; i++) {
            if (i == 0) {
                f[i] = nums[i];
            } else {
                f[i] = f[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return f[j];
        } else {
            return f[j] - f[i - 1];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);