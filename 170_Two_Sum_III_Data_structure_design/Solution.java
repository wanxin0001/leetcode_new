/*
170. Two Sum III - Data structure design  QuestionEditorial Solution  My Submissions
Total Accepted: 15021
Total Submissions: 65487
Difficulty: Easy
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Hide Company Tags LinkedIn
Hide Tags Hash Table Design
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*
Prefer for add
*/
public class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) {
	        map.put(number, 2);
	    } else {
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        int first = entry.getKey();
	        int second = value - first;
	        
	        if (second != first) {
	            if (map.containsKey(second)) {
	                return true;
	            }
	        } else {
	            if (map.get(first) == 2) {
	                return true;
	            }
	        }
	    }
	    
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);


/*
Prefer for find
*/
public class TwoSum {
    Set<Integer> sum = new HashSet<Integer>();
    Set<Integer> num = new HashSet<Integer>();


    // Add the number to an internal data structure.
	public void add(int number) {
	    if (num.contains(number)) {
	        sum.add(number * 2);
	    } else {
	        for (int item : num) {
	            sum.add(item + number);
	        }
	        num.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return sum.contains(value);
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);