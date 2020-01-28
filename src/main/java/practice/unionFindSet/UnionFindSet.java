package practice.unionFindSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 19.10.19.
 * <p>
 * 实现一个并查集结构，使得查询两个集合，查询两个集合是否属于同一个集合的时间复杂度都为O(1)
 */
public class UnionFindSet {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      list.add(i);
    }
    UnionSet unionSet = new UnionSet(list);
    unionSet.printContent();

    unionSet.merge(1, 2);
    unionSet.merge(2, 3);
    unionSet.merge(10, 11);
    unionSet.merge(10, 12);
    unionSet.merge(3, 12);
    unionSet.printContent();

    System.out.println(unionSet.isSameSet(3, 12));
    System.out.println(unionSet.isSameSet(2, 10));

    unionSet.merge(14, 12);
    unionSet.printContent();
    System.out.println(unionSet.isSameSet(2, 14));
  }

  /**
   * 这里使用node的主要目的是，在merge的时候，可以将 parentMap.put(n, nParentNode)，nParentNode是引用具有传递性，n的所有
   * 子节点的parent都会切成nParentNode。
   */
  public static class Node {
    public int value;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "" + value;
    }
  }

  public static class UnionSet {
    private HashMap<Integer, Node> parentMap;
    private HashMap<Node, Integer> sizeMap;

    public UnionSet(List<Integer> datas) {
      parentMap = new HashMap<>();
      sizeMap = new HashMap<>();
      for (Integer item : datas) {
        Node node = new Node(item);
        parentMap.put(item, node);
        sizeMap.put(node, 1);
      }
    }

    public Node findParent(int n) {
      Node parent = parentMap.get(n);
      if (parent.value != n) {
        parent = findParent(parent.value);
      }
      parentMap.put(n, parent);
      return parent;
    }

    public boolean isSameSet(int n1, int n2) {
      return findParent(n1).value == findParent(n2).value;
    }

    public void merge(int n1, int n2) {
      Node parent1 = findParent(n1);
      Node parent2 = findParent(n2);
      if (parent1.value == parent2.value) {
        return;
      }
      int size1 = sizeMap.get(parent1);
      int size2 = sizeMap.get(parent2);

      if (size1 >= size2) {
        parentMap.put(parent2.value, parent1);
        sizeMap.put(parent1, size1 + size2);
      } else {
        parentMap.put(parent1.value, parent2);
        sizeMap.put(parent2, size1 + size2);
      }
    }

    public void printContent() {
      System.out.println("parentMap:" + parentMap.entrySet());
      System.out.println("sizeMap" + sizeMap.entrySet());
      System.out.println();
    }
  }
}
