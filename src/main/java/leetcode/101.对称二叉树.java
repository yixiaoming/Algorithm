package leetcode;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode t1, TreeNode t2){
        if( t1 == null && t2 == null ) return true;
        if( t1 == null || t2 == null ) return false;
        if( t1.val != t2.val ) return false;
        return check(t1.left, t2.right) && check(t1.right, t2.left);
    }
}
// @lc code=end

