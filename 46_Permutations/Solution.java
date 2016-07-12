/*
46. Permutations  QuestionEditorial Solution  My Submissions
Total Accepted: 108076
Total Submissions: 292856
Difficulty: Medium
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<Integer>();
        
        dfsHelper(result, tmp, nums, flag);
        
        return result;
    }
    
    private void dfsHelper(List<List<Integer>> result, List<Integer> tmp, int[] nums, boolean[] flag) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                tmp.add(nums[i]);
                dfsHelper(result, tmp, nums, flag);
                tmp.remove(tmp.size() - 1);
                flag[i] = false;
            }
        }
    }
}