/*
260. Single Number III  QuestionEditorial Solution  My Submissions
Total Accepted: 44408 Total Submissions: 95312 Difficulty: Medium
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Tags Bit Manipulation
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
Reference: https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations/2
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        
        diff &=-diff;
        
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        
        return result;
    }
}