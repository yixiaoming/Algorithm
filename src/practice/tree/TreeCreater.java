package practice.tree;

/**
 * Created by Administrator on 19.10.16.
 */
public class TreeCreater {

  /**
   *     1
   *   2   3
   * 4  5 6  7
   * @return
   */
  public static TreeNode createBanlanceTree(){
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
    return head;
  }

  /**
   *       1
   *   2     3
   * 4  5   6
   *     7
   * @return
   */
  public static TreeNode createRandomTree(){
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n5.right = n7;
    return n1;
  }
}
