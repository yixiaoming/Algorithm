package practice.sort;

import practice.utils.Utils;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.6.
 */
public class MergeSort {

  private static int tab = 0;

  public static void main(String[] args) {
    int[] arr = Utils.createIntArr(100, 6);
    check(arr);
  }

  private static void rightMethod(int[] arr) {
    Arrays.sort(arr);
  }

  private static void check(int[] arr) {
    int[] arr1 = new int[arr.length];
    int[] arr2 = new int[arr.length];
    System.arraycopy(arr, 0, arr1, 0, arr.length);
    System.arraycopy(arr, 0, arr2, 0, arr.length);

    System.out.println(Arrays.toString(arr));
    rightMethod(arr1);
    mergeSort(arr2, 0, arr2.length - 1);

    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        throw new RuntimeException("error partion!");
      }
    }
    System.out.println("right");
  }

  private static void mergeSort(int[] arr, int left, int right) {
    int mid = left + ((right - left) >> 1);
    System.out.printf(getTabs() + "l=%d,mid=%d,mid+1=%d,r=%d\n", left, mid, mid + 1, right);

    if (left >= right) {
      return;
    }

    tab += 2;
    mergeSort(arr, left, mid);
    tab -= 2;
    tab += 2;
    mergeSort(arr, mid + 1, right);
    tab -= 2;
    merge(arr, left, mid, right);
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    int i = left;
    int j = mid + 1;
    int[] temp = new int[right - left + 1];
    int k = 0;
    while (i <= mid && j <= right) {
      temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) {
      temp[k++] = arr[i++];
    }
    while (j <= right) {
      temp[k++] = arr[j++];
    }
    System.out.println(getTabs() + Arrays.toString(temp));
    System.arraycopy(temp, 0, arr, left, temp.length);
  }

  public static String getTabs() {
    StringBuilder tabs = new StringBuilder();
    for (int i = 0; i < tab; i++) {
      tabs.append(" ");
    }
    return tabs.toString();
  }
}
