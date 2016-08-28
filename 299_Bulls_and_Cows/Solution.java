/*
299. Bulls and Cows  QuestionEditorial Solution  My Submissions
Total Accepted: 38893
Total Submissions: 123577
Difficulty: Easy
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

Credits:
Special thanks to @jeantimex for adding this problem and creating all test cases.

Show Tags

*/
public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        for (int i = 0; i < guess.length(); i++) { //seperate them
            char c = guess.charAt(i);
            if (c == secret.charAt(i)) {
                map.put(c, map.get(c) - 1);
                bull++;
            }
        }
        
        for (int i = 0; i < guess.length(); i++) { //seperate them
            char c = guess.charAt(i);
            if (c != secret.charAt(i)) {
                if (map.containsKey(c) && map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                    cow++;
                }
            }
        }
        
        return Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
    }
}