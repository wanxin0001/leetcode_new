/*
179. Largest Number  QuestionEditorial Solution  My Submissions
Total Accepted: 53339
Total Submissions: 263148
Difficulty: Medium
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Tags Sort
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        boolean notAllZeros = false;
        for (int num : nums) {
            if (num != 0) {
                notAllZeros = true;
                break;
            }
        }
        
        if (!notAllZeros) {
            return "0";
        }
        
        String[] array = new String[nums.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(array, new MyComparator());
        String str = "";
        for (String num : array) {
            str = num + str;
        }
        
        return str;
    }
    
    private class MyComparator implements Comparator<String> {
      public int compare(String a, String b) {
          return (a + b).compareTo(b + a); //rather than a < b
      }  
    };
}