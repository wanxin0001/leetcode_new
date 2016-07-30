/*
49. Group Anagrams  QuestionEditorial Solution  My Submissions
Total Accepted: 84305
Total Submissions: 291545
Difficulty: Medium
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        for (Map.Entry<String, List<String>> pair : map.entrySet()) {
            result.add(pair.getValue());
        }
        
        return result;
    }
}