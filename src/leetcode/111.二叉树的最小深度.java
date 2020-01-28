package leetcode;/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if (leftMinDepth != 0 && rightMinDepth != 0) {
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        }
        return leftMinDepth == 0 ? rightMinDepth + 1 : leftMinDepth + 1;
    }
}
// @lc code=end

