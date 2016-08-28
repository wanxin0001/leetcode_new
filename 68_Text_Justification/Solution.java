/*
68. Text Justification  QuestionEditorial Solution  My Submissions
Total Accepted: 38398
Total Submissions: 226905
Difficulty: Hard
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
Hide Company Tags LinkedIn Airbnb
Hide Tags String
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/4189/share-my-concise-c-solution-less-than-20-lines/2
*/
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<String>();
        
        for (int i = 0, w; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {
                len += words[w].length() + 1;
            }
        
        
            StringBuilder sb = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if (w != i + 1 && w != words.length) {
                space = (maxWidth - len) / (w - i - 1) + 1;
                extra = (maxWidth - len) % (w - i - 1);
            }
            
            for (int j = i + 1; j < w; j++) {
                for (int s = space; s > 0; s--) {
                    sb.append(" ");
                }
                
                if (extra-- > 0) {
                    sb.append(" ");
                }
                
                sb.append(words[j]);
            }
            
            int strLen = maxWidth - sb.length();
            while (strLen > 0) {
                sb.append(" ");
                strLen--;
            }
            
            list.add(sb.toString());
        }
        return list;
    }
}