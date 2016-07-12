/*
216. Combination Sum III  QuestionEditorial Solution  My Submissions
Total Accepted: 37157
Total Submissions: 98943
Difficulty: Medium
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0 || k > n) {
            return result;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        dfsHelper(result, tmp, k, n, 1);
        
        return result;
    }
    
    private void dfsHelper(List<List<Integer>> result, List<Integer> tmp, int k, int n, int pos) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        } else if (n == 0 && k != 0 || n != 0 && k == 0 || n < 0) {
            return;
        }
        
        for (int i = pos; i <= 9; i++) {// less and EQUAL to 9
            tmp.add(i);
            dfsHelper(result, tmp, k - 1, n - i, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}