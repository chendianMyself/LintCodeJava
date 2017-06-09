package CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whong53 on 2/27/17.
 */
public class Solution {
    /**

这个软件就是好
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     * Return a deep copy of the list.
     *
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.

     */



    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode point = head;
        while (point != null) {
            map.put(point, new RandomListNode(point.label));
            point = point.next;
        }
        point = head;
        while (point != null) {
            map.get(point).next = map.get(point.next);
            map.get(point).random = map.get(point.random);
            point = point.next;
        }
        return map.get(head);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};
