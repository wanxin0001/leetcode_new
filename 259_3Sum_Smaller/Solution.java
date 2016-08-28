/*
259. 3Sum Smaller  QuestionEditorial Solution  My Submissions
Total Accepted: 12677
Total Submissions: 32135
Difficulty: Medium
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

Hide Company Tags Google
Hide Tags Array Two Pointers
Hide Similar Problems (M) 3Sum (M) 3Sum Closest
Have you met this question in a real interview? Yes  No
Discuss
*/

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums); //very necessary
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    count += right - left;
                    left++;
                    //right--; need to remove
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }
}