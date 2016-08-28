/*
358. Rearrange String k Distance Apart  QuestionEditorial Solution  My Submissions
Total Accepted: 2103
Total Submissions: 7280
Difficulty: Hard
Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
Example 2:
str = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.
Example 3:
str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.
Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.
*/
/*
https://discuss.leetcode.com/topic/48260/java-15ms-solution-with-two-auxiliary-array-o-n-time
*/
public class Solution {
    public String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a'] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            int candidate = findValidMax(count, valid, i);
            if (candidate == -1) {
                return "";
            } else {
                count[candidate] -= 1;
                valid[candidate] = i + k;
                sb.append((char)('a' + candidate));
            }
            
        }
        
        return sb.toString();
    }
    
    private int findValidMax(int[] count, int[] valid, int index) {
        int max = Integer.MIN_VALUE;
        int pos = - 1;
        for (int i = 0; i < count.length; i++ ){
            if (count[i] > 0 && count[i] > max && valid[i]<= index) {
                max = count[i];
                pos = i;
            }
        }
        
        return pos;
    }
}