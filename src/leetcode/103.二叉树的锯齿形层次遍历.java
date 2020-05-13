import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean isLeft = true;
        LinkedList<Integer> line = new LinkedList<>();
        while (!queue.isEmpty()) {
            // printQueue(queue);
            TreeNode node = queue.pollFirst();
            if (node != null) {
                if (isLeft) {
                    line.addLast(node.val);
                } else {
                    line.addFirst(node.val);
                }

                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            } else {
                result.add(line);
                line = new LinkedList<>();
                isLeft = !isLeft;
                if (queue.peekFirst() != null) {
                    queue.addLast(null);
                }
            }
        }
        return result;
    }

    public void printQueue(List<TreeNode> queue){
        for(TreeNode node:queue){
            if(node != null){
                System.out.printf("%d,", node.val);
            }else{
                System.out.printf("null,");
            }
        }
        System.out.println();
    }
}
// @lc code=end
