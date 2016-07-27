/*
131. Palindrome Partitioning  QuestionEditorial Solution  My Submissions
Total Accepted: 69032
Total Submissions: 244456
Difficulty: Medium
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        List<String> tmp = new ArrayList<String>();
        dfs(result, tmp, s);
        
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> tmp, String s) {
        if (s.length() == 0) {
            result.add(new ArrayList<String>(tmp));
            return;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                tmp.add(s.substring(0, i));
                dfs(result, tmp, s.substring(i));
                tmp.remove(tmp.size() - 1);
            }
        }
        
    }
    
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}