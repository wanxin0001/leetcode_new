/*
251. Flatten 2D Vector  QuestionEditorial Solution  My Submissions
Total Accepted: 12373
Total Submissions: 34585
Difficulty: Medium
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Hint:

How many variables do you need to keep track?
Two variables is all you need. Try with x and y.
Beware of empty rows. It could be the first few rows.
To write correct code, think about the invariant to maintain. What is it?
The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
Not sure? Think about how you would implement hasNext(). Which is more complex?
Common logic in two different places should be refactored into a common method.
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Vector2D implements Iterator<Integer> {
    private Stack<List<Integer>> stack1;
    private Stack<Integer> stack2;
    public Vector2D(List<List<Integer>> vec2d) {
        stack1 = new Stack<List<Integer>>();
        stack2 = new Stack<Integer>();
        for (int i = vec2d.size() - 1; i >= 0; i--) {
            stack1.push(vec2d.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack2.pop();
    }

    @Override
    public boolean hasNext() {
        if (!stack2.empty()) {
            return true;
        }
        
        while (!stack1.empty() && stack2.empty()) {
            List<Integer> list = stack1.pop();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack2.push(list.get(i));
            }
        }
        
        return !stack2.empty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */