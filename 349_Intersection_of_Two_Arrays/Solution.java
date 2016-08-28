/*
349. Intersection of Two Arrays  QuestionEditorial Solution  My Submissions
Total Accepted: 37710
Total Submissions: 84787
Difficulty: Easy
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> tmp = new HashSet<Integer>();
        HashSet<Integer> interset = new HashSet<Integer>();
        
        for (int num : nums1) {
            tmp.add(num);
        }
        
        for (int num : nums2) {
            if (tmp.contains(num)) {
                interset.add(num);
            }
        }
        
        int[] result = new int[interset.size()];
        int i = 0;
        for (int num : interset) {
            result[i] = num;
            i++;
        }
        
        return result;
    }
}