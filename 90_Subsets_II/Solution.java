/*
90. Subsets II My Submissions Question
Total Accepted: 63584 Total Submissions: 210607 Difficulty: Medium
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

Solution:
- create tmp and result array list
- NOTICE: do array sort to make sure the values in non-descending order
- use subsetsHelper to do recursion
- In recursion
-- add tmp to result
--- Go into a for loop
---- add a new element into tmp list 
---- do a further recursion
---- remove this element 
---- check if it has duplicated elements. If it has, go through the array until finding the unduplicated element

*/


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        subsetsWithDupHelper(result, tmp, nums, 0);
        
        return result;
    }
    
    private void subsetsWithDupHelper(List<List<Integer>> result, List<Integer> tmp, int[] nums, int index) {
        result.add(new ArrayList<Integer>(tmp));
        
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            subsetsWithDupHelper(result, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
            
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
    
    
}