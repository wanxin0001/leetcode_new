/*
15. 3Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 132017
Total Submissions: 675729
Difficulty: Medium
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
Show Company Tags
Hide Tags Array Two Pointers
Hide Similar Problems (E) Two Sum (M) 3Sum Closest (M) 4Sum (M) 3Sum Smaller
Have you met this question in a real interview? Yes  No
Discuss
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 2) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                    while(left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    
                    while(left < right && nums[right] == nums[right + 1]) {
                        right --;
                    }
                    
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            
            
            while(i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        
        return result;
    }
}