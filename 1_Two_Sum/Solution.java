/*
1. Two Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 265255
Total Submissions: 1054427
Difficulty: Easy
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int val2 = target - nums[i];
            if (!map.containsKey(val2)) {
                map.put(nums[i], i);
            } else {
                result[0] = i;
                result[1] = map.get(val2);
                break;
            }
        }
        
        return result;
    }
}