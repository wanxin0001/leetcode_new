/*
159. Longest Substring with At Most Two Distinct Characters  QuestionEditorial Solution  My Submissions
Total Accepted: 14791
Total Submissions: 40324
Difficulty: Hard
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }
        
        if (s.length() <= 2) {
            return s.length();
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Queue<Character> queue = new LinkedList<Character>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
                queue.offer(cur);
                
            } else {
                if (map.size() == 2) {
                    while(map.size() == 2) {
                        char out = queue.poll();
                        map.put(out, map.get(out) - 1);
                        if (map.get(out) == 0) {
                            map.remove(out);
                        }
                    }
                    
                    
                } 
                queue.offer(cur);
                map.put(cur, 1);
                
                
            }
            max = Math.max(max, queue.size());
        }
        
        return max;
    }
}