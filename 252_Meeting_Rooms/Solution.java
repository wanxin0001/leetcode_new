/*
252. Meeting Rooms  QuestionEditorial Solution  My Submissions
Total Accepted: 13929
Total Submissions: 32161
Difficulty: Easy
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        
        Arrays.sort(intervals, new IntervalComparator());
        Interval last = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (last.end > cur.start) {
                return false;
            }
            
            last = cur;
        }
        
        return true;
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}