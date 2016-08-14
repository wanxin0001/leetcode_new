/*
13. Roman to Integer  QuestionEditorial Solution  My Submissions
Total Accepted: 98096
Total Submissions: 237874
Difficulty: Easy
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
/*
Reference: http://www.jiuzhang.com/solutions/roman-to-integer/
*/
public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int val = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                val += map.get(s.charAt(i));
            } else {
                val -= map.get(s.charAt(i));
            }
        }
        
        return val;
        
    }
}