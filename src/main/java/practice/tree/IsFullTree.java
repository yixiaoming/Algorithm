package practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 19.10.14.
 *
 * 判断是否是完全二叉树
 * 按照层遍历
 * 1. 如果有一个节点有右无左孩子直接返回false
 * 2. 如果有一个节点有左无右，左右双无。那么后面所有节点都必须是叶子节点，否则返回false
 *
 * 另外一个做法：按层遍历转层数组，看是有空的位置
 */
public class IsFullTree {

  public static void main(String[] args) {
    TreeNode root = TreeCreater.createBanlanceTree();

    System.out.println(isFullTree(root));
  }

  private static boolean isFullTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isLeaf = false;
    while (!queue.isEmpty()) {
      root = queue.poll();
      if (root.left == null && root.right != null) {
        return false;
      }
      if (isLeaf && (root.left != null || root.right != null)) {
        return false;
      }
      if (root.left == null || root.right == null) {
        isLeaf = true;
      }
      if (root.left != null) {
        queue.add(root.left);
      }
      if (root.right != null) {
        queue.add(root.right);
      }
    }
    return true;
  }
}
