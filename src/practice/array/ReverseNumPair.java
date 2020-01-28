package practice.array;

import practice.utils.Utils;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.7.
 * <p>
 * 逆序对：一个数组中，如果左边的数比右边的数大，则构成一组逆序对
 * 请打印数组中所有的逆序对
 */
public class ReverseNumPair {

  public static void main(String[] args) {
    int[] arr = Utils.createIntArr(10, 10);
    System.out.println(Arrays.toString(arr));
    System.out.println(rightMethod(arr));
    System.out.println(printReverseNumPair(arr, 0, arr.length - 1));
    System.out.println(Arrays.toString(arr));
  }

  private static int rightMethod(int[] arr) {
    if (arr == null || arr.length == 1) {
      return 0;
    }
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[i]) {
          result++;
        }
      }
    }
    return result;
  }

  private static int printReverseNumPair(int[] arr, int l, int r) {
    if (l == r) {
      return 0;
    }
    int mid = l + ((r - l) >> 1);
    return printReverseNumPair(arr, l, mid) +
      printReverseNumPair(arr, mid + 1, r) +
      processNumPair(arr, l, mid, r);
  }

  private static int processNumPair(int[] arr, int l, int mid, int r) {
    int p1 = mid;
    int p2 = r;
    int[] temp = new int[r - l + 1];
    int k = r - l + 1 - 1;
    int result = 0;
    while (p1 >= l && p2 >= mid + 1) {
      if (arr[p1] > arr[p2]) {
        result += (p2 - (mid + 1) + 1);
      }
      temp[k--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
    }
    while (p1 >= l) {
      temp[k--] = arr[p1--];
    }
    while (p2 >= mid + 1) {
      temp[k--] = arr[p2--];
    }

    System.arraycopy(temp, 0, arr, l, r - l + 1);
    return result;
  }
}
