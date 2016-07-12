/*
77. Combinations  QuestionEditorial Solution  My Submissions
Total Accepted: 81536
Total Submissions: 229673
Difficulty: Medium
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        dfsHelper(result, tmp, n, k, 1);
        
        return result;
    }
    
    private void dfsHelper(List<List<Integer>> result, List<Integer> tmp, int n, int k, int pos) {
        if (tmp.size() == k) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for (int i = pos; i <= n; i++) {
            tmp.add(i);
            dfsHelper(result, tmp, n, k, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}