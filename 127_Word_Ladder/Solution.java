/*
127. Word Ladder  QuestionEditorial Solution  My Submissions
Total Accepted: 86034
Total Submissions: 437005
Difficulty: Medium
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Show Company Tags
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/

/*
Reference: https://discuss.leetcode.com/topic/29303/two-end-bfs-in-java-31ms
*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        
        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] array = word.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = array[i];
                        array[i] = c;
                        String target = String.valueOf(array);
                        
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        array[i] = old;
                    }
                    
                }
            }
            
            beginSet = temp;
            len++;
            
        }
        
        return 0;
    }
}