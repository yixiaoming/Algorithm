import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int i=0;
        while(i<inorder.length){
            inMap.put(inorder[i], i);
            i++;
        }
        return process(inorder, postorder);
    }

    public TreeNode process(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        int val = postorder[postorder.length - 1];
        int inPos = inMap.get(val);

        TreeNode root = new TreeNode(val);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, inPos), Arrays.copyOfRange(postorder, 0, inPos));
        root.right = buildTree(Arrays.copyOfRange(inorder, inPos + 1, inorder.length),
                Arrays.copyOfRange(postorder, inPos, postorder.length - 1));
        return root;
    }
}
// @lc code=end

