/*
56. Merge Intervals  QuestionEditorial Solution  My Submissions
Total Accepted: 76995
Total Submissions: 289708
Difficulty: Hard
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Show Company Tags
Show Tags
Hide Similar Problems (H) Insert Interval (E) Meeting Rooms (M) Meeting Rooms II
Have you met this question in a real interview? Yes  No
Discuss Pick One

*/
/*
Reference:
http://www.jiuzhang.com/solutions/merge-intervals/
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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new IntervalComparator());
        
        List<Interval> result = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (last.end >= cur.start) {
                last.end = Math.max(last.end, cur.end);
            } else {
                result.add(last);
                last = cur;
            }
        }
        
        result.add(last);
        return result;
        
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval val1, Interval val2) {
            return val1.start - val2.start;
        }
    }
}