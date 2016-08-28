/*
3. Longest Substring Without Repeating Characters  QuestionEditorial Solution  My Submissions
Total Accepted: 174003
Total Submissions: 759572
Difficulty: Medium
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Show Company Tags
Show Tags
Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters

*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Queue<Character> queue = new LinkedList<Character>();
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            while (map.containsKey(cur)) {
                char out = queue.poll();
                map.put(out, map.get(out) - 1);
                if(map.get(out) == 0) {
                    map.remove(out);
                }
            }
            
            map.put(cur, 1);
            queue.offer(cur);
            max = Math.max(queue.size(), max);
        }
        
        return max;
    }
}