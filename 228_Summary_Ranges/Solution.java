/*
228. Summary Ranges  QuestionEditorial Solution  My Submissions
Total Accepted: 53689
Total Submissions: 207637
Difficulty: Medium
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Array
Hide Similar Problems (M) Missing Ranges (H) Data Stream as Disjoint Intervals
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (right < (nums.length - 1) && nums[right] + 1 == nums[right + 1]) {
                right++;
                continue;
            }
            result.add(toString(nums[left], nums[right])); //rather than left, right
            
            right++;
            left = right;
        }
        
        if (left < nums.length) {
            result.add(toString(nums[left], nums[right])); //rather than left, right
        }
        
        return result;
    }
    
    private String toString(int left, int right) {
        String str = Integer.toString(left);
        if (left < right) {
            str += "->" + Integer.toString(right);
        }
        
        return str;
    }
}