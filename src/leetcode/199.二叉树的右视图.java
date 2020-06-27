import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList();
        if(root==null) return list;
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode p = queue.pollFirst();
            if(p == null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }
            if(queue.peek() == null){
                list.add(p.val);
            }
            if(p.left != null) queue.add(p.left);
            if(p.right != null) queue.add(p.right);
        }
        return list;
    }
}
// @lc code=end

