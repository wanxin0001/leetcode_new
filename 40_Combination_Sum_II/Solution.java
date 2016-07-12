/*
40. Combination Sum II  QuestionEditorial Solution  My Submissions
Total Accepted: 74428
Total Submissions: 261540
Difficulty: Medium
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Show Tags
Show Similar Problems

*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }
        
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<Integer>();
        dfsHelper(result, tmp, candidates, target, 0);
        
        return result;
    }
    
    private void dfsHelper(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int pos) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        } else if (target < 0) {
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            dfsHelper(result, tmp, candidates, target - candidates[i], i + 1);
            tmp.remove(tmp.size() - 1);
            
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}