/*
341. Flatten Nested List Iterator  QuestionEditorial Solution  My Submissions
Total Accepted: 13312
Total Submissions: 39380
Difficulty: Medium
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

Hide Company Tags Google Facebook Twitter
Hide Tags Stack Design
Hide Similar Problems (M) Flatten 2D Vector (M) Zigzag Iterator (M) Mini Parser
Have you met this question in a real interview? Yes  
*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
 /*
 Reference: https://discuss.leetcode.com/topic/42042/simple-java-solution-using-a-stack-with-explanation/2
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
        
    }

    @Override
    public boolean hasNext() {   //we cannot put while to next(), the reason is if we do this thing, there is a special case:
    //input [[]], expected result should be [], but it will return [null]
        while (!stack.isEmpty()) {
            NestedInteger cur = stack.peek();
            
            if (cur.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = cur.getList().size() - 1; i >= 0; i--) { //rather than cur.size()
                stack.push(cur.getList().get(i));
            }
            
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */