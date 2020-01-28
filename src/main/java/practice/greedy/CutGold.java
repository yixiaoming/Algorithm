package practice.greedy;

import java.util.PriorityQueue;

/**
 * Created by Administrator on 19.10.22.
 *
 * 切金条
 *
 * 给定一个数组 golds[3,10,20,5,2], 表示需要切出来每段金条的长度。金条的总长度为数组所有数之和。
 * 每切一刀需要花费金条长度等额的铜板。求：怎么切能使花费的铜板最少。
 */
public class CutGold {

  public static void main(String[] args) {
    System.out.println(getCutGold(new int[]{5, 3, 1, 2, 3}));
  }

  // 哈夫曼编码
  public static int getCutGold(int[] golds) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int item : golds) {
      queue.add(item);
    }
    if (golds.length <= 1) {
      return 0;
    }
    int custs = 0;
    while (queue.size() > 1) {
      int gold1 = queue.poll();
      int gold2 = queue.poll();
      System.out.println(gold1+","+gold2);
      custs += (gold1 + gold2);
      queue.add(gold1 + gold2);
    }
    return custs;
  }
}
