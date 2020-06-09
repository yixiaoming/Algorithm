import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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

    int maxResult = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        process(root);
        return maxResult;
    }

    public int process(TreeNode root) {
        if(root == null) return 0;
        int leftSum = Math.max(process(root.left), 0);
        int rightSum = Math.max(process(root.right), 0);


        int result = root.val + leftSum + rightSum;
        if(result > maxResult) maxResult = result;

        return root.val + Math.max(leftSum, rightSum);
    }
}
// @lc code=end

