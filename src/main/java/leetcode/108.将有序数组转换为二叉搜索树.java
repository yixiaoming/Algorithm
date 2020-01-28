package leetcode;/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = makeTree(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode makeTree(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int pos = (left + right) / 2;
        TreeNode node = new TreeNode(nums[pos]);
        node.left = makeTree(nums, left, pos - 1);
        node.right = makeTree(nums, pos + 1, right);
        return node;
    }
}
// @lc code=end

