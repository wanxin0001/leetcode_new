/*
336. Palindrome Pairs  QuestionEditorial Solution  My Submissions
Total Accepted: 10935 Total Submissions: 49478 Difficulty: Hard
Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google Airbnb
Hide Tags Hash Table String Trie
Hide Similar Problems (M) Longest Palindromic Substring (H) Shortest Palindrome
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
Reference: https://discuss.leetcode.com/topic/40657/150-ms-45-lines-java-solution
*/
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (words == null || words.length < 2) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {// rather than j < words[i].length() becasuse word can be ""
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPadlindrome(str1)) {
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rev) && map.get(str2rev) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rev));
                        list.add(i);
                        result.add(list);
                    }
                }
                
                if (isPadlindrome(str2)) {
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rev) && map.get(str1rev) != i && str2.length() != 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rev));
                        result.add(list);
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isPadlindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        
        return true;
    }
}