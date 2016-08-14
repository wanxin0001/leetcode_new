/*
368. Largest Divisible Subset  QuestionEditorial Solution  My Submissions
Total Accepted: 7231
Total Submissions: 23319
Difficulty: Medium
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]
Credits:
Special thanks to @Stomach_ache for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
/*
For an increasingly sorted array of integers a[1 .. n]

T[n] = the length of the largest divisible subset whose largest number is a[n]

T[n+1] = max{ 1 + T[i] if a[n+1] mod a[i] == 0 else 1 }

Now, deducting T[n] becomes straight forward with a DP trick. For the final result we will need to maintain a backtrace array for the answer.


Reference: https://discuss.leetcode.com/topic/49456/c-solution-with-explanations
*/
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        int[] f = new int[nums.length];
        int[] parent = new int[nums.length];
        
        int max = 0;
        int maxIdx = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && f[i] < 1 + f[j]) {
                    f[i] = f[j] + 1;
                    parent[i] = j;
                    
                    if (f[i] > max) {
                        max = f[i];
                        maxIdx = i;
                    }
                }
            }
        }
        
        for (int i = 0; i < max; i++) {
            result.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }
        
        return result;
    }
}