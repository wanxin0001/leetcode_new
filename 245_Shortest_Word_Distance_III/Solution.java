/*
245. Shortest Word Distance III  QuestionEditorial Solution  My Submissions
Total Accepted: 9984
Total Submissions: 21015
Difficulty: Medium
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1, len = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    pos1 = pos2;
                    pos2 = i;
                    
                    if (pos1 != -1 && pos2 != -1) {
                        len = Math.min(len, Math.abs(pos1 - pos2));
                    }
                }
            }
            
            return len;
        } else {
            for (int i = 0; i < words.length; i++) {
                if (word1.equals(words[i])) {
                    pos1 = i;
                }
                
                if (word2.equals(words[i])) {
                    pos2 = i;
                }
                
                if (pos1 != -1 && pos2 != -1) {
                    len = Math.min(len, Math.abs(pos1 - pos2));
                }
            }
            
            return len;
        }
    }
}