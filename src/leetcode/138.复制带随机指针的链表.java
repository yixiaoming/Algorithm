import java.util.HashMap;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    Map<Node, Node> nodeMap = new HashMap();

    public Node copyRandomList(Node head) {
        if( head == null ) return head;
        if(nodeMap.containsKey(head)){
            return nodeMap.get(head);
        }
        Node n = new Node(head.val);
        nodeMap.put(head, n);
        n.next = copyRandomList(head.next);
        n.random = copyRandomList(head.random);
        return n;
    }
}
// @lc code=end

