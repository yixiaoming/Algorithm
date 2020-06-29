import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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

    private int pre(TreeNode root){
        root = root.left;
        while(root.right!=null) root = root.right;
        return root.val;
    }

    private int next(TreeNode root){
        root = root.right;
        while(root.left != null) root = root.left;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        } else if(root.val > key){
            root.left = deleteNode(root.left, key);
        } else{
            if(root.left == null && root.right == null){
                root = null;
            } else if(root.right != null){
                root.val = next(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = pre(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
// @lc code=end

