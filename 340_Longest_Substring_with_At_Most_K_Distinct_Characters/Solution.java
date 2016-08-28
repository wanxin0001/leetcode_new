/*
340. Longest Substring with At Most K Distinct Characters  QuestionEditorial Solution  My Submissions
Total Accepted: 5050
Total Submissions: 12926
Difficulty: Hard
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        if (k <= 0) {
            return 0;
        }
        
        Queue<Character> queue = new LinkedList<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
                queue.offer(cur);
                max = Math.max(max, queue.size());
            } else {
                if (map.size() < k) {
                    map.put(cur, 1);
                    queue.offer(cur);
                    max = Math.max(max, queue.size());
                } else {
                    while (map.size() == k) {
                        char out = queue.poll();
                        map.put(out, map.get(out) - 1);
                        if (map.get(out) == 0) {
                            map.remove(out);
                        }
                    }
                    queue.offer(cur);
                    if (map.containsKey(cur)) {
                        map.put(cur, map.get(cur) + 1);
                    } else {
                        map.put(cur, 1);
                    }
                    
                }
            }
        }
        
        return max;
    }
}