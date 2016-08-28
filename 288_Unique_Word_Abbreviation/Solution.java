/*
288. Unique Word Abbreviation  QuestionEditorial Solution  My Submissions
Total Accepted: 13641
Total Submissions: 86657
Difficulty: Easy
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
Hide Company Tags Google
Hide Tags Hash Table Design
Hide Similar Problems (E) Two Sum III - Data structure design (M) Generalized Abbreviation
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
public class ValidWordAbbr {

    private HashMap<String, HashSet<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, HashSet<String>>();
        
        for (String str : dictionary) {
            String tmp;
            if (str.length() <= 2) {
                tmp = str;
            } else {
                tmp = "" + str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
            }
            
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str);
            } else{
                HashSet<String> set = new HashSet<String>();
                set.add(str);
                map.put(tmp, set);
            }
        }
    }

    public boolean isUnique(String str) {
        String tmp = "";
        if (str.length() <= 2) {
            tmp = str;
        } else {
            tmp = "" + str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
        }
        
        if (!map.containsKey(tmp) || map.containsKey(tmp) && map.get(tmp).contains(str) && map.get(tmp).size() == 1) {  //the condition is very necessary
            return true;
        } else {
            return false;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");