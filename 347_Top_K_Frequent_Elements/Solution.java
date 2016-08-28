/*
347. Top K Frequent Elements  QuestionEditorial Solution  My Submissions
Total Accepted: 25695
Total Submissions: 58684
Difficulty: Medium
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
Show Company Tags
Show Tags
Hide Similar Problems (M) Word Frequency (M) Kth Largest Element in an Array

*/
/*
Reference: https://discuss.leetcode.com/topic/44237/java-o-n-solution-bucket-sort
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List[] bucket = new List[nums.length + 1]; //perfect idea
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<Integer>();
            }
            bucket[val].add(key);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        
        return result;
    }
}