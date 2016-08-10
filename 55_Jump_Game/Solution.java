/*
55. Jump Game  QuestionEditorial Solution  My Submissions
Total Accepted: 86933
Total Submissions: 302030
Difficulty: Medium
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        boolean[] f = new boolean[nums.length];
        f[0] = true;
        for (int i = 1; i < f.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && j + nums[j] >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[f.length - 1];
    }
}