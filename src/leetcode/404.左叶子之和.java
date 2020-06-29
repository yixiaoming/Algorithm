/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    int leftLeafSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        process(root, false);
        return leftLeafSum;
    }

    public void process(TreeNode root, boolean isLeft){
        if(root == null) return;
        if(isLeft && root.left == null && root.right == null){
            leftLeafSum += root.val;
        }
        process(root.left, true);
        process(root.right, false);
    }
}
// @lc code=end

