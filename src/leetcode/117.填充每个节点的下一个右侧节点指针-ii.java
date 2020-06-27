/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        LinkedList<Node> que = new LinkedList();
        que.add(root);
        que.add(null);
        while (!que.isEmpty()) {
            Node r = que.pollFirst();
            if (r == null) {
                if(!que.isEmpty()){
                    que.add(null);
                }
                continue;
            }
            r.next = que.peekFirst();
            if (r.left != null) {
                que.add(r.left);
            }
            if (r.right != null) {
                que.add(r.right);
            }
        }
        return root;
    }
}
// @lc code=end

