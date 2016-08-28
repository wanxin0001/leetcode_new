/*
352. Data Stream as Disjoint Intervals  QuestionEditorial Solution  My Submissions
Total Accepted: 4849
Total Submissions: 12811
Difficulty: Hard
Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?

Credits:
Special thanks to @yunhong for adding this problem and creating most of the test cases.

Hide Tags Binary Search Tree
Hide Similar Problems (M) Summary Ranges
Have you met this question in a real interview? Yes  No
Discuss
*/
/*
Reference: https://discuss.leetcode.com/topic/46887/java-solution-using-treemap-real-o-logn-per-adding
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> tree;
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<Integer, Interval>();
    }
    
    public void addNum(int val) {
        if (tree.containsKey(val)) {
            return;
        }
        
        Integer l = tree.lowerKey(val); // not int
        Integer h = tree.higherKey(val); // not int
        
        if (l != null && h != null && tree.get(l).end + 1 == val && val + 1 == tree.get(h).start) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if (l != null && tree.get(l).end >= val - 1) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if (h != null && tree.get(h).start == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
        
        return;
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(tree.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */