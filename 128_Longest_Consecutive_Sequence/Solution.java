/*
128. Longest Consecutive Sequence  QuestionEditorial Solution  My Submissions
Total Accepted: 73338
Total Submissions: 218921
Difficulty: Hard
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        if (nums.length <= 1) {
            return nums.length;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);   
        }
        
        int max = 0;
        while (set.size() != 0) {
            Iterator it = set.iterator();
            int val = (int) it.next();
            set.remove(val);
            int count = 1;
            int left = val - 1;
            int right = val + 1;
            while(set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}