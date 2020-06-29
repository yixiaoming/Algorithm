/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    public int rob(TreeNode root) {
        int[] result = process(root);
        return Math.max(result[0], result[1]);
    }

    public int[] process(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = process(root.left);
        int[] right = process(root.right);
        int baohan = root.val + left[0] + right[0];
        int bubaohan = left[1]+right[1];
        return new int[]{bubaohan, Math.max(baohan, bubaohan)};
    }
}
// @lc code=end

