package practice.sort;

import practice.utils.Utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Administrator on 19.10.5.
 */
public class QuikSort {

  static int p = 0;

  public static void main(String[] args) {


//    System.out.println(Arrays.toString(practice.arr));
//    quickSort(practice.arr, 0, practice.arr.length - 1);
//    System.out.println(Arrays.toString(practice.arr));
    for (int i = 0; i <= 10; i++) {
      int[] arr = Utils.createIntArr(10, 10);
      check(arr);
    }
  }

  public static void check(int[] arr) {
    int[] arr1 = Utils.copyIntArr(arr);
    int[] arr2 = Utils.copyIntArr(arr);
    quickSort3(arr1, 0, arr1.length - 1);
    Arrays.sort(arr2);
    System.out.println(Utils.arrEquals(arr1, arr2));
  }

  public static void quickSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = partion(arr, left, right);
      quickSort(arr, left, mid - 1);
      quickSort(arr, mid + 1, right);
    }
  }

  public static void quickSort2(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    Stack<Integer> stack = new Stack<>();
    stack.push(left);
    stack.push(right);
    while (!stack.isEmpty()) {
      right = stack.pop();
      left = stack.pop();
      int mid = partion(arr, left, right);
      if (mid > left) {
        stack.push(left);
        stack.push(mid - 1);
      }
      if (mid < right) {
        stack.push(mid + 1);
        stack.push(right);
      }
    }
  }

  public static void quickSort3(int[] arr, int left, int right) {
    if (left < right) {
      // 随机快排
      Utils.swap(arr, left + new Random().nextInt(right - left), right);
      int[] mids = henanPartion(arr, left, right, arr[right]);
      quickSort3(arr, left, mids[0] - 1);
      quickSort3(arr, mids[1] + 1, right);
    }
  }

  public static int partion(int[] arr, int left, int right) {
    int start = left;
    for (int i = left; i < right; i++) {
      if (arr[i] <= arr[right]) {
        Utils.swap(arr, i, start);
        start++;
      }
    }
    Utils.swap(arr, start, right);
    return start;
  }

  /**
   * 使用荷兰国旗问题，优化快排，优化点：等于num的数在最中间，返回left和right不包含所有num
   * 优化二：如果数组本来就有序，如果每次使用最后一个数字作为num，时间复杂度变成 O(n^2)，所以最好随机一下num。
   */
  public static int[] henanPartion(int[] arr, int left, int right, int num) {
    int less = left - 1;
    int more = right + 1;
    int cur = left;
    while (cur < more) {
      if (arr[cur] < num) {
        Utils.swap(arr, ++less, cur++);
      } else if (arr[cur] > num) {
        Utils.swap(arr, --more, cur);
      } else {
        cur++;
      }
    }
    return new int[]{less + 1, more - 1};
  }
}
