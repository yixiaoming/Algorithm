package practice.utils;

/**
 * Created by Administrator on 19.10.7.
 */
public class Utils {

  public static int[] copyIntArr(int[] arr) {
    int[] arrCopy = new int[arr.length];
    System.arraycopy(arr, 0, arrCopy, 0, arr.length);
    return arrCopy;
  }

  public static int[] createIntArr(int max, int length) {
    int[] arr = new int[length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
    }
    return arr;
  }

  public static boolean arrEquals(int[] arr1, int[] arr2) {
    if (arr1 == null && arr2 == null) {
      return true;
    }
    if (arr1 == null || arr2 == null) {
      return false;
    }
    if (arr1.length != arr2.length) {
      return false;
    }
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
  }
}
