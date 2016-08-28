/*
307. Range Sum Query - Mutable  QuestionEditorial Solution  My Submissions
Total Accepted: 17320
Total Submissions: 93859
Difficulty: Medium
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*
https://leetcode.com/articles/range-sum-query-mutable/
*/
public class NumArray {
    int[] tree;
    int n;
    
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[2 * n];
            buildTree(nums);
        }    
    }
    
    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < 2* n; i++, j++) {
            tree[i] = nums[j];
        }
        
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    public int sumRange(int i, int j) {
        i +=n;
        j +=n;
        int sum = 0;
        while (i <= j) {
            if (i % 2 == 1) {
                sum += tree[i];
                i++;
            }
            if (j % 2 == 0) {
                sum += tree[j];
                j--;
            }
            
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);