/*
205. Isomorphic Strings  QuestionEditorial Solution  My Submissions
Total Accepted: 67293
Total Submissions: 217974
Difficulty: Easy
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            if (s== null && t== null) {
                return true;
            }
            
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int[] sArray = getVal(s, map);
        
        map = new HashMap<Character, Integer>();
        int[] tArray = getVal(t, map);
        
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            } 
        }
        
        return true;
    }
    
    private int[] getVal(String s, HashMap<Character, Integer> map) {
        int[] sArray = new int[s.length()];
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                sArray[i] = map.get(cur);
            } else {
                map.put(cur, val);
                sArray[i] = val;
                val++;
            }
        }
        
        return sArray;
    }
}