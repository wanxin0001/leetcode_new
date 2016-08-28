/*
346. Moving Average from Data Stream  QuestionEditorial Solution  My Submissions
Total Accepted: 6666
Total Submissions: 11752
Difficulty: Easy
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
public class MovingAverage {
    private int size;
    private double sum;
    private int count;
    private Queue<Integer> queue;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        count = 0;
        queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if (count < size) {
            sum += val;
            count++;
            queue.add(val);
            return sum / count;
        } else {
            int last = queue.poll();
            sum = sum + val - last;
            queue.add(val);
            return sum / count;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */