/*
138. Copy List with Random Pointer  QuestionEditorial Solution  My Submissions
Total Accepted: 70395
Total Submissions: 269366
Difficulty: Hard
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;
        
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            map.put(cur, newNode);
            cur = cur.next;
        }
        
        cur = head;
        while (cur != null) {
            RandomListNode newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            if (cur.random != null) {
                newCur.random = map.get(cur.random);
            }
            cur = cur.next;
        }
        
        return map.get(head); // It is not cur
    }
}