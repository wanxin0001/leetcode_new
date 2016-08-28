/*
274. H-Index  QuestionEditorial Solution  My Submissions
Total Accepted: 43452
Total Submissions: 141756
Difficulty: Medium
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Hide Similar Problems (M) H-Index II
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/23307/my-o-n-time-solution-use-java
*/
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int[] array = new int[citations.length + 1];
        int len = citations.length;
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= len) {
                array[len] += 1;
            } else {
                array[citations[i]] += 1;
            }
        }
        
        int t = 0;
        for (int i = len; i >= 0; i--) {
            t = t + array[i];
            if (t >= i) {
                return i;
            }
        }
        
        return 0;
    }
}