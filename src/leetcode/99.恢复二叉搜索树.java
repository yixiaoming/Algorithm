import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import org.graalvm.compiler.asm.sparc.SPARCAssembler.BitKeyIndex;

import jdk.nashorn.api.tree.YieldTree;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode x =null, y = null, pred = null;

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if(pred != null && root.val < pred.val){
                y = root;
                if(x == null){
                    x = pred;
                }else break;
            }

            pred = root;
            root = root.right;
        }

        int temp = x.val;
        x.val =y.val;
        y.val = temp;
    }


}
// @lc code=end

