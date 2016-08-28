/*
243. Shortest Word Distance  QuestionEditorial Solution  My Submissions
Total Accepted: 14828
Total Submissions: 30663
Difficulty: Easy
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/20668/ac-java-clean-solution/2
*/
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, distance = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            
            if (words[i].equals(word2)) {
                p2 = i;
            }
            
            if (p1 != -1 && p2 != -1) {
                distance = Math.min(distance, Math.abs(p1 - p2));
            }
        }
        
        return distance;
    }
}