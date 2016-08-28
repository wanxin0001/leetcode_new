/*
126. Word Ladder II  QuestionEditorial Solution  My Submissions
Total Accepted: 49726
Total Submissions: 361733
Difficulty: Hard
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
/*
Very hard
Reference: https://discuss.leetcode.com/topic/2857/share-two-similar-java-solution-that-accpted-by-oj/19
*/
public class Solution {
    List<List<String>> results;
    List<String> list;
    Map<String, List<String>> map;
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            results = new ArrayList<List<String>>();
            
            if (dict.size() == 0) {
                return results;
            }
            
            int curr = 1, next = 0;
            boolean found = false;
            
            list = new LinkedList<String>();
            map = new HashMap<String, List<String>>();
            Queue<String> queue = new LinkedList<String>();
            Set<String> unvisited = new HashSet<String>(dict);
            Set<String> visited = new HashSet<String>();
            
            queue.add(start);
            unvisited.add(end);
            unvisited.remove(start);
            
            while(!queue.isEmpty()) {
                String word = queue.poll();
                curr--;
                for (int i = 0; i < word.length(); i++) {
                    char[] array = word.toCharArray();
                    char old = array[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        
                        array[i] = j;
                        String target = new String(array);
                        if (unvisited.contains(target)) {
                            if (visited.add(target)) {
                                next++;
                                queue.add(target);
                            }
                            if (map.containsKey(target)) {
                                map.get(target).add(word);
                            } else {
                                List<String> list = new LinkedList<String>();
                                list.add(word);
                                map.put(target, list);
                            }
                            
                            if (target.equals(end) && !found) {
                                found = true;
                            }
                        }
                        
                        
                        
                    }
                    array[i] = old;
                   
                }
                
                if (curr == 0) {
                    if (found) {
                        break;
                    }
                    
                    curr = next;
                    next = 0;
                    unvisited.removeAll(visited);
                    visited.clear();
                }
            }
            
            
            
            backtrace(end, start);
            return results;
        
    }
    
    private void backtrace(String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                backtrace(s, start);
            }
        }
        
        list.remove(0);
    }
}