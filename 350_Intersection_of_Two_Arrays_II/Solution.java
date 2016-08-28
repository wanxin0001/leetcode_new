/*
350. Intersection of Two Arrays II  QuestionEditorial Solution  My Submissions
Total Accepted: 26591
Total Submissions: 63508
Difficulty: Easy
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        } 
        
        int[] a = nums1.length >= nums2.length ? nums1 : nums2;
        int[] b = nums1.length < nums2.length ? nums1 : nums2;
        
        HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> intermap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < b.length; i++) {
            if (tmp.containsKey(b[i])) {
                tmp.put(b[i], tmp.get(b[i]) + 1);
            } else {
                tmp.put(b[i], 1);
            }
        }
        
        for (int i = 0; i < a.length; i++) {
            if (tmp.containsKey(a[i]) && tmp.get(a[i]) > 0) {
                if (intermap.containsKey(a[i])) {
                    intermap.put(a[i], intermap.get(a[i]) + 1);
                } else {
                    intermap.put(a[i], 1);
                }
                
                tmp.put(a[i], tmp.get(a[i]) - 1);
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : intermap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        
        int[] array = new int[result.size()];
        int i = 0;
        for (int item : result) {
            array[i] = item;
            i++;
        }
        
        return array;
    }
}