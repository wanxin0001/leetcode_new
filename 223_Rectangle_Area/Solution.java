/*
223. Rectangle Area  QuestionEditorial Solution  My Submissions
Total Accepted: 44309
Total Submissions: 143444
Difficulty: Easy
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.

Credits:
Special thanks to @mithmatt for adding this problem, creating the above image and all test cases.

Show Tags
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/17705/just-another-short-way/2
*/
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        
        int bottom = Math.max(B, F);
        int top = Math.max(Math.min(D, H), bottom);
        
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }
}