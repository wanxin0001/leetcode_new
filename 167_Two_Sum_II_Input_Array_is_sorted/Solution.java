/*
167. Two Sum II - Input array is sorted  QuestionEditorial Solution  My Submissions
Total Accepted: 17824
Total Submissions: 36026
Difficulty: Medium
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        
        return result;
    }
}