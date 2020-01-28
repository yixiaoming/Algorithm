package practice.tree;

/**
 * Created by Administrator on 19.10.14.
 * <p>
 * 判断树是否是平衡二叉树
 * 判断：1.左子树是否是平衡二叉树，不是直接返回
 * 2.右子树是否是平衡二叉树，不是直接返回
 * 3.判断左右子树的高度相差是否大于1，大于1直接返回
 * 4.如果相等，返回树高度
 */
public class IsBanlanceTree {

  public static void main(String[] args) {
    TreeNode head = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
//    head.left = n2;
    head.right = n3;
//    n2.left = n4;
//    n2.right = n5;
    n3.left = n6;
    n3.right = n7;

    PrintTree.layerOrderPrint(head);
    System.out.println(judgeBanlanceTree(head) >= 0);
  }

  private static int judgeBanlanceTree(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    if (-1 == judgeBanlanceTree(treeNode.left)) {
      return -1;
    }
    if (-1 == judgeBanlanceTree(treeNode.right)) {
      return -1;
    }

    int leftHeight = judgeBanlanceTree(treeNode.left);
    int rightHeight = judgeBanlanceTree(treeNode.right);
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
