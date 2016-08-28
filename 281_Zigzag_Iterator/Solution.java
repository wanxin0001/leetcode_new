/*
281. Zigzag Iterator  QuestionEditorial Solution  My Submissions
Total Accepted: 12681
Total Submissions: 28135
Difficulty: Medium
Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class ZigzagIterator {
    private int cur = 0;
    private int min;
    private int len;
    private boolean v1longer;
    
    private List<Integer> v1;
    private List<Integer> v2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        min = Math.min(v1.size(), v2.size());
        len = v1.size() + v2.size();
        v1longer = v1.size() >= v2.size();
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        int out;
        if (cur + 1 <= min * 2) {
            if (cur % 2 == 0) {
                out = v1.get(cur / 2);
            } else {
                out = v2.get(cur / 2);
            }
        } else {
            if (v1longer) {
                out = v1.get(cur - min);
            } else {
                out = v2.get(cur - min);
            }
        }
        cur++;
        return out;
    }

    public boolean hasNext() {
        if (cur < len) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */