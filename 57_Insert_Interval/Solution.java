/*
57. Insert Interval  QuestionEditorial Solution  My Submissions
Total Accepted: 65647
Total Submissions: 264474
Difficulty: Hard
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss 
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
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        
        int insertPos = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
                insertPos++;
            } else if (newInterval.end < interval.start) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        
        result.add(insertPos, newInterval);
        
        return result;
    }
}