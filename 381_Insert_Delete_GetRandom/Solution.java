/*
381. Insert Delete GetRandom O(1) - Duplicates allowed  QuestionEditorial Solution  My Submissions
Total Accepted: 1827
Total Submissions: 6022
Difficulty: Hard
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class RandomizedCollection {
    
    HashMap<Integer, Set<Integer>> map;
    List<Integer> list;
    int next;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<Integer>();
        next = 0;
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            HashSet<Integer> vals = new HashSet<Integer>();
            vals.add(next);
            map.put(val, vals);
            list.add(val);
            next++;
            return true;
        } else {
            map.get(val).add(next);
            list.add(val);
            next++;
            return false;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int loc = map.get(val).iterator().next();
            if (map.get(val).size() == 1) {
                map.remove(val);
            } else {
                map.get(val).remove(loc);
            }
            
            if (list.get(list.size() - 1) != val) {
                list.set(loc, list.get(list.size() - 1));
                map.get(list.get(list.size() - 1)).remove(list.size() - 1);
                map.get(list.get(list.size() - 1)).add(loc);
            }
            
            next--;
            list.remove(list.size()  - 1); 
            
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int n = rand.nextInt(next);
        return list.get(n);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */