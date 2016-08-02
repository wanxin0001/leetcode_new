/*
219. Contains Duplicate II  QuestionEditorial Solution  My Submissions
Total Accepted: 69257
Total Submissions: 226612
Difficulty: Easy
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) { 
            return false;
        }
        

        
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int i = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                List<Integer> list = map.get(num);
                int last = list.get(list.size() - 1);
                if (i - last <= k) {
                    return true;
                }
                
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(num, list);
            }
            i++;
        }
        
        
        return false;
    }
}