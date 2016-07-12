/*
47. Permutations II  QuestionEditorial Solution  My Submissions
Total Accepted: 77246
Total Submissions: 268931
Difficulty: Medium
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                tmp.add(nums[i]);
                dfsHelper(result, tmp, nums, flag);
                tmp.remove(tmp.size() - 1);
                flag[i] = false;
                
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) {   // while statement must be in the if statement.
                    i++;
                }
            }
            
            
        }
    }
}