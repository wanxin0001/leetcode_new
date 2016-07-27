/*
93. Restore IP Addresses  QuestionEditorial Solution  My Submissions
Total Accepted: 60506
Total Submissions: 250293
Difficulty: Medium
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        dfs(result, "", s, 0);
        
        return result;
    }
    
    private void dfs(List<String> result, String tmp, String s, int pos) {
        if (pos == 4) {
            if (s.length() == 0) { //Very important
                result.add(new String(tmp.substring(0, tmp.length() - 1)));
            }
            return;
        }
        
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (isIpSubstring(s.substring(0, i))) {
                dfs(result, tmp + s.substring(0, i) + ".", s.substring(i), pos + 1);
            }
        } 
    }
    
    private boolean isIpSubstring(String s) {
        if (s.length() != 1 && s.substring(0, 1).equals("0")) { //s.length() != 1 is important.
            return false;
        }
        
        int val = Integer.parseInt(s);
        if (val >= 0 && val <= 255) {
            return true;
        } else {
            return false;
        }
    }
}