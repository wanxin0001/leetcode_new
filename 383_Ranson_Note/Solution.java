/*
383. Ransom Note  QuestionEditorial Solution  My Submissions
Total Accepted: 5534
Total Submissions: 12128
Difficulty: Easy
 Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean canConstruct(String ransomNode, String magazine) {
        if (ransomNode == null || ransomNode.length() == 0) {
            return true;
        }
        
        if (magazine == null || magazine.length() == 0) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            char cur = magazine.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        
        for (int i = 0; i < ransomNode.length(); i++) {
            char cur = ransomNode.charAt(i);
            if (map.containsKey(cur) && map.get(cur) >= 1) {
                map.put(cur, map.get(cur) - 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
}