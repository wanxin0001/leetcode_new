/*
163. Missing Ranges  QuestionEditorial Solution  My Submissions
Total Accepted: 14362
Total Submissions: 47547
Difficulty: Medium
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

Hide Company Tags Google
Hide Tags Array
Hide Similar Problems (M) Summary Ranges
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            result.add(toString(lower, upper));
            return result;
        }
        
        if (lower < nums[0]) {
            result.add(toString(lower, nums[0] - 1));
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                result.add(toString(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        
        if (nums[nums.length - 1] < upper) {
            result.add(toString(nums[nums.length - 1] + 1, upper));
        }
        
        return result;
    }
    
    private String toString(int low, int upper) {
        String str = Integer.toString(low);
        if (low < upper) {
            str += "->" + Integer.toString(upper);
        }
        return str;
    }
}