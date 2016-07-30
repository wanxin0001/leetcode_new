/*
169. Majority Element  QuestionEditorial Solution  My Submissions
Total Accepted: 130755
Total Submissions: 306205
Difficulty: Easy
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems

*/


public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int mid = (nums.length + 1) / 2;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            
            if (map.get(num) >= mid) {
                return num;
            }
        }
        
        return -1;
    }
}