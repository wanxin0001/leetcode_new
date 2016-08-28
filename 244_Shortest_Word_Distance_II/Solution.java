/*
244. Shortest Word Distance II  QuestionEditorial Solution  My Submissions
Total Accepted: 10374
Total Submissions: 29264
Difficulty: Medium
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

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
public class WordDistance {
    
    HashMap<String, List<Integer>> map; 
    
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (map.containsKey(str)) {
                map.get(str).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(str, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        HashSet<Integer> set1 = new HashSet<Integer>(list1);
        HashSet<Integer> set2 = new HashSet<Integer>(list2);
        
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(list1);
        list.addAll(list2);
        Collections.sort(list);
        int pos1 = -1;
        int pos2 = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < list.size(); i++) {
            if (set1.contains(list.get(i))) {
                pos1 = list.get(i); //rather than i
            }
            
            if (set2.contains(list.get(i))) {
                pos2 = list.get(i); //rather than i
            }
            
            if (pos1 != -1 && pos2 != -1) {
                min = Math.min(min, Math.abs(pos1 - pos2));
            }
        }
        
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");