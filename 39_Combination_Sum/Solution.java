/*
39. Combination Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 99779
Total Submissions: 311343
Difficulty: Medium
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        dfsHelper(result, tmp, candidates, target, 0);
        
        return result; 
    }
    
    private void dfsHelper(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int pos) {
        if (0 == target) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        } else if (0 > target) {
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            dfsHelper(result, tmp, candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}