/*
 * @lc app=leetcode.cn id=112 lang=kotlin
 *
 * [112] 路径总和
 */

// @lc code=start
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum == root.`val`){
            return true;
        }else{
            return hasPathSum(root.left, sum-root.left.`val`) || hasPathSum(root.right, sum-root.right.`val`);
        }
    }
}
// @lc code=end

