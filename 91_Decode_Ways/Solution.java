/*
91. Decode Ways  QuestionEditorial Solution  My Submissions
Total Accepted: 78365
Total Submissions: 434971
Difficulty: Medium
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] array = new int[s.length() + 1];
        array[0] = 1;
        for (int i = 1; i < array.length; i++) {
            if (s.charAt(i - 1) != '0') {
                array[i] += array[i - 1];
            }
            
            if (i >= 2) {
                String str = s.substring(i - 2, i);  // rather than (i - 1, i + 1)
                if (str.charAt(0) != '0') {
                    int val = Integer.parseInt(str);
                    if (val >= 10 && val <= 26) {
                        array[i] += array[i - 2];
                    }
                }
            }
        }
        
        return array[s.length()];
    }
    
    
}