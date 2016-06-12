/*
344. Reverse String My Submissions QuestionEditorial Solution
Total Accepted: 35860 Total Submissions: 61081 Difficulty: Easy
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

public class Solution {
    public String reverseString(String s) {
        if(s.length() < 2) {
            return s;
        }
    
        StringBuilder result = new StringBuilder();
    
        for(int i = s.length()-1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
    
        return result.toString();
    }
}