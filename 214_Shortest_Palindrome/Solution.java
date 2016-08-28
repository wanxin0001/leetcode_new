/*
214. Shortest Palindrome  QuestionEditorial Solution  My Submissions
Total Accepted: 24936
Total Submissions: 117548
Difficulty: Hard
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Thanks to @Freezen for additional test cases.

Hide Company Tags Pocket Gems Google
Hide Tags String
Hide Similar Problems (M) Longest Palindromic Substring (E) Implement strStr() (H) Palindrome Pairs
Have you met this question in a real interview? Yes  No
Discuss
*/
/*
https://discuss.leetcode.com/topic/14770/my-easily-understandable-but-time-consuming-c-solution
*/
class Solution {
public:
    string shortestPalindrome(string s) {
        string s2 = s;
        reverse(s2.begin(), s2.end());
        int n = s.size(), l;
        for (l = n; l >= 0; l--) {
            if (s.substr(0, l) == s2.substr(n - l)) {
                break;
            }
        }
        
        return s2.substr(0, n - l) + s;
    }
};