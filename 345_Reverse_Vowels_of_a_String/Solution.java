/*
345. Reverse Vowels of a String  QuestionEditorial Solution  My Submissions
Total Accepted: 37862
Total Submissions: 103924
Difficulty: Easy
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss 
*/
public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        } 
        
        char[] array = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (!set.contains(s.charAt(left))) {
                left++;
                continue;
            }
            
            if (!set.contains(s.charAt(right))) {
                right--;
                continue;
            }
            
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++; //necessary
            right--;  //necessary
        }
        
        return new String(array);
    }
}