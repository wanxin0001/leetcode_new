/*
217. Contains Duplicate  QuestionEditorial Solution  My Submissions
Total Accepted: 105251
Total Submissions: 248670
Difficulty: Easy
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Show Company Tags
Show Tags
Show Similar Problems
*/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
       if (nums == null || nums.length <= 1) {
           return false;
       }
       
       HashSet<Integer> set = new HashSet<Integer>();
       for (int num : nums) {
           if (set.contains(num)) {
               return true;
           } else {
               set.add(num);
           }
       }
       
       return false;
    }
}