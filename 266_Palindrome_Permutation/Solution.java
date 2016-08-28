/*
266. Palindrome Permutation  QuestionEditorial Solution  My Submissions
Total Accepted: 16006
Total Submissions: 30440
Difficulty: Easy
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        int[] array = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int val = (int) s.charAt(i);
            array[val] = (array[val] + 1) % 2;
        }
        
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        
        if (s.length() % 2 == 0) {
            return sum == 0;
        } else {
            return sum == 1;
        }
    }
}