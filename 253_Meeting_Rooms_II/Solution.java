/*
253. Meeting Rooms II  QuestionEditorial Solution  My Submissions
Total Accepted: 15052
Total Submissions: 41506
Difficulty: Medium
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

Show Company Tags
Hide Tags Heap Greedy Sort
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/20958/ac-java-solution-using-min-heap
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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        
        queue.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval last = queue.poll();
            Interval cur = intervals[i];
            
            if (last.end <= cur.start) {
                last.end = Math.max(last.end, cur.end);
            } else {
                queue.offer(cur);
            }
            
            queue.offer(last);
        }
        
        return queue.size();
        
    }
}