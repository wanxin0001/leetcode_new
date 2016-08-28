/*
292. Nim Game  QuestionEditorial Solution  My Submissions
Total Accepted: 91293
Total Submissions: 169097
Difficulty: Easy
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

Show Hint 
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
Reference: https://discuss.leetcode.com/topic/26999/theorem-all-4s-shall-be-false
*/
public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}