package practice.tree;

/**
 * Created by Administrator on 19.10.9.
 *
 * 镜像树
 */
public class ReverseTree {

  public static void main(String[] args) {
    TreeNode head = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    head.left = n2;
    head.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;

    reverseTree(head);
    PrintTree.layerOrderPrint(head);
  }

  public static void reverseTree(TreeNode node) {
    if (node == null) {
      return;
    }

    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;

    reverseTree(node.left);
    reverseTree(node.right);
  }
}
