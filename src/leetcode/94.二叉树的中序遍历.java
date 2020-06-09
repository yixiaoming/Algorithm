package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList();   
        Stack<TreeNode> stack = new Stack();
        while(!stack.isEmpty() || root!=null) {
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            results.add(root.val);
            root = root.right;
        }
        return results;
    }

    // public void process(List<Integer> list, TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     process(list, root.left);
    //     list.add(root.val);
    //     process(list, root.right);
    // }


}
// @lc code=end

