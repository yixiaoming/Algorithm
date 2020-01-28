package practice.tree;

/**
 * Created by Administrator on 19.10.14.
 *
 * 求一个完全二叉树的节点个数，要求时间复杂度低于 O(N)
 *
 * 任意一个节点，如果其右子树到达最底层，则左子树是满二叉树根据公式求，然后求右子树所有节点数相加。
 * 如果右子树没有到达最底层，则右子树层数-1是满二叉树。递归求左子树所有节点然后相加
 */
public class GetFullTreeCount {

  public static void main(String[] args) {
    
  }
}
