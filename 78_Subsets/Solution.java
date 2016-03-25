/*
78. Subsets My Submissions Question
Total Accepted: 89836 Total Submissions: 289933 Difficulty: Medium
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
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
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        subsetsHelper(result, list, nums, 0);
        
        return result;
    }
    
    private void subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<Integer>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
        return;
    }
}