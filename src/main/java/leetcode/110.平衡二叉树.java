package leetcode;/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        return process(root) != -1;
    }

    public int process(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = process(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = process(root.right);
        if (rightDepth == -1) return -1;
        if (Math.abs(leftDepth-rightDepth)>1) return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
}
// @lc code=end

