/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
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
    public int sumNumbers(TreeNode root) {
        int[] result = new int[]{0};
        process(root, 0, result);
        return result[0];
    }

    public void process(TreeNode root,int num, int[] result){
        if(root == null) return;
        num = num*10 + root.val;
        if(root.left == null && root.right == null){
            result[0] += num;
        }
        process(root.left, num, result);
        process(root.right, num, result);
    }
}
// @lc code=end

