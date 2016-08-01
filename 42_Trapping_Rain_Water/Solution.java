/*
42. Trapping Rain Water  QuestionEditorial Solution  My Submissions
Total Accepted: 73811
Total Submissions: 222372
Difficulty: Hard
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int start = 0;
        int end = height.length - 1;
        int smaller;
        int area = 0;
        
        while (start < end) {
            if (height[start] < height[end]) {
                smaller = height[start];
                while(start < end && height[start] <= smaller) {
                    area += smaller - height[start];
                    start++;
                }
            } else {
                smaller = height[end];
                while(start < end && height[end] <= smaller) {
                    area += smaller - height[end];
                    end--;
                }
            }
        }
        
        return area;
    }
}