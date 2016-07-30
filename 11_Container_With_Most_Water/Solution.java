/*
11. Container With Most Water  QuestionEditorial Solution  My Submissions
Total Accepted: 86898
Total Submissions: 245875
Difficulty: Medium
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/
public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            result = Math.max(result, getArea(height, left, right));
            
            if (height[left] < height[right]) {
                left++;   
            } else {
                right--;
            }
        }
        
        return result;
    }
    
    private int getArea(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) * (right - left);
    }
}