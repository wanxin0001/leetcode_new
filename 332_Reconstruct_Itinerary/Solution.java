/*
332. Reconstruct Itinerary  QuestionEditorial Solution  My Submissions
Total Accepted: 14209
Total Submissions: 55354
Difficulty: Medium
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
*/

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }
        
        HashMap<String, List<String>> map = buildHashMap(tickets);
        List<String> tmp = new ArrayList<String>();
        tmp.add("JFK");
        dfs(result, tmp, map, "JFK", tickets.length);
        return result;
    }
    
    private void dfs(List<String> result, List<String> tmp, HashMap<String, List<String>> map, String from, int length) {
        if (result.size() > 0) {
            return;
        }
        if (tmp.size() == length + 1) {
            result.addAll(new ArrayList<String>(tmp));
            return;
        }
        if (map.containsKey(from)) {
            for (int i = 0; i < map.get(from).size(); i++) {
                String to = map.get(from).get(i);
                tmp.add(to);
                map.get(from).remove(i);
                dfs(result, tmp, map, to, length);
                map.get(from).add(i, to);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    private HashMap<String, List<String>> buildHashMap(String[][] tickets) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < tickets.length; i++) {
            if (map.containsKey(tickets[i][0])) {
                map.get(tickets[i][0]).add(tickets[i][1]);
            } else {
                List<String> values = new ArrayList<String>();
                values.add(tickets[i][1]);
                map.put(tickets[i][0], values);
            }
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        
        return map;
    }
}