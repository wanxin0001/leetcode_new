/*
17. Letter Combinations of a Phone Number  QuestionEditorial Solution  My Submissions
Total Accepted: 87218
Total Submissions: 294371
Difficulty: Medium
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] array = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(result, "", digits, array, 0);
        
        return result;
    }
    
    private void dfs(List<String> result, String tmp, String digits, String[] array, int pos) {
        if (tmp.length() == digits.length()) {
            result.add(tmp);
            return;
        }
        
        int index = Integer.parseInt(digits.substring(pos, pos + 1)) - 1;
        for (int i = 0; i < array[index].length(); i++) {
            dfs(result, tmp + array[index].substring(i, i + 1), digits, array, pos + 1);
        }
    }
}