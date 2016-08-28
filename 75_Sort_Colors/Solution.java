/*
75. Sort Colors  QuestionEditorial Solution  My Submissions
Total Accepted: 112638
Total Submissions: 315858
Difficulty: Medium
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
Hide Company Tags Pocket Gems Microsoft Facebook
Hide Tags Array Two Pointers Sort
Hide Similar Problems (M) Sort List (M) Wiggle Sort (M) Wiggle Sort II
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/5422/share-my-one-pass-constant-space-10-line-solution/5
*/
public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        
        int low = 0;
        int high = A.length - 1;
        for (int i = low; i <= high;) {
            if (A[i] == 0) {
                int tmp = A[i];
                A[i] = A[low];
                A[low] = tmp;
                i++;
                low++;
            } else if (A[i] == 2) {
                int tmp = A[i];
                A[i] = A[high];
                A[high] = tmp;
                high--;
            } else {
                i++;
            }
        }
        
        return;
    }
}