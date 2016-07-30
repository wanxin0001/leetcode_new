/*
88. Merge Sorted Array  QuestionEditorial Solution  My Submissions
Total Accepted: 111346
Total Submissions: 364792
Difficulty: Easy
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur;
        if (n == 0) {
            return;
        } else if (m == 0) 
        {
           cur = n - 1;
        } else {
            cur = m + n - 1;
        }
        
        
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[cur] = nums1[m];
                cur--;
                m--;
            } else {
                nums1[cur] = nums2[n];
                cur--;
                n--;
            }
        }
        
        while (n >= 0) {
            nums1[cur] = nums2[n];
            cur--;
            n--;
        }
        return;
    }
}