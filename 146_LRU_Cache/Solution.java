/*
146. LRU Cache  QuestionEditorial Solution  My Submissions
Total Accepted: 84025
Total Submissions: 530281
Difficulty: Hard
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Hide Company Tags Google Uber Facebook Twitter Zenefits Amazon Microsoft Snapchat Yahoo Bloomberg Palantir
Hide Tags Design
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
http://www.jiuzhang.com/solutions/lru-cache/
*/
public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }
    
    private Node head;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return - 1;
        }
        
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        move_to_tail(cur);
        
        return cur.value;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        
       
        
        if (map.size() == capacity) {
            Node first = head.next;
            head.next = first.next;
            first.next.prev = head;
            map.remove(first.key);
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        move_to_tail(insert);
    }
    
    private void move_to_tail(Node insert) {
        Node last = tail.prev;
        last.next = insert;
        insert.prev = last;
        insert.next = tail;
        tail.prev = insert;
    }
}