package practice.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 19.10.22.
 *
 * 最大收益
 *
 * 给定两个数组：cost[5,20,10,1], profit[7,30,2,10], 分别表示做一个项目的花费和纯利润。求总金额W，
 * 最多做K个项目，怎么选择项目使最终受益最大。
 */
public class MoreProfit {

  public static void main(String[] args) {
    int[] costs = new int[]{10, 5, 26, 10};
    int[] profits = new int[]{5, 3, 10, 8};
    System.out.println(getBestProfit(costs, profits, 10, 3));
  }

  private static class Product {
    int cost;
    int profit;

    public Product(int cost, int profit) {
      this.cost = cost;
      this.profit = profit;
    }
  }

  public static int getBestProfit(int[] costs, int[] profits, int W, int k) {
    // 花费小顶堆
    PriorityQueue<Product> costQueue = new PriorityQueue<>(new Comparator<Product>() {
      @Override
      public int compare(Product o1, Product o2) {
        return o1.cost - o2.cost;
      }
    });
    // 收入大顶堆
    PriorityQueue<Product> profitQueue = new PriorityQueue<>(new Comparator<Product>() {
      @Override
      public int compare(Product o1, Product o2) {
        return o2.profit - o1.profit;
      }
    });
    for (int i = 0; i < costs.length; i++) {
      costQueue.add(new Product(costs[i], profits[i]));
    }

    int i = 0;
    while (i < k) {
      // 将符合要求的所有花费product弹出放入收益大顶堆中
      while (!costQueue.isEmpty() && W >= costQueue.peek().cost) {
        profitQueue.add(costQueue.poll());
      }
      if (profitQueue.isEmpty()) {
        break;
      }
      // 每次取收益最大的做
      if (!profitQueue.isEmpty()) {
        W += profitQueue.poll().profit;
        i++;
      }
    }
    return W;
  }
}
