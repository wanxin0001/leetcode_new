/*
53. Maximum Subarray  QuestionEditorial Solution  My Submissions
Total Accepted: 124418
Total Submissions: 333751
Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
// A very good algorithm question.
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (tmp[i - 1] > 0) {
                tmp[i] = tmp[i - 1] + nums[i];
            } else {
                tmp[i] = nums[i];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int val : tmp) {
            max = Math.max(val, max);
        }
        
        return max;
    }
}