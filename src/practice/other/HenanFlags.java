package practice.other;

import practice.utils.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 19.10.7.
 * <p>
 * 荷兰国旗问题：数组中，将小于n的数都放到左边，大于n的数都放右边，等于n的数放中间
 */
public class HenanFlags {

  public static void main(String[] args) {
    int[] arr = Utils.createIntArr(10, 10);
    int random = new Random().nextInt(9);
    System.out.println(random + ":" + arr[random]);
    henanFlag(arr, arr[random]);
    System.out.println(Arrays.toString(arr));
  }

  private static void henanFlag(int[] arr, int n) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    int less = 0;
    int more = arr.length - 1;
    int cur = 0;
    while (cur <= more) {
      if (arr[cur] < n) {
        Utils.swap(arr, less++, cur++);
      } else if (arr[cur] > n) {
        Utils.swap(arr, cur, more--);
      } else {
        cur++;
      }
    }
  }
}
