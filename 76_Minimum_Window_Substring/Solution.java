/*
76. Minimum Window Substring  QuestionEditorial Solution  My Submissions
Total Accepted: 67727 Total Submissions: 304797 Difficulty: Hard
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
/*
It also has a general template

Here comes the template.

For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions. A general way is to use a hashmap assisted with two pointers. The template is given below.
  
Reference: https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems

*/
public class Solution {
    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0) {
            return "";
        }   
        if (s == null || s.length() < t.length()) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int counter = t.length();
        int start = 0, end = 0, len = Integer.MAX_VALUE, head = -1;
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    counter--;
                }
            }
            end++;
            
            while (counter == 0) {
                if (end - start < len) {
                    len = end - start;
                    head = start;
                }
                
                char cc = s.charAt(start);
                if (map.containsKey(cc)) {
                    map.put(cc, map.get(cc) + 1);
                    if (map.get(cc) > 0) {
                        counter++;
                    }
                    
                }
                
                start++;
            }
            
        }
        
        return head == -1 ? "" : s.substring(head, head + len);
        
    }
}