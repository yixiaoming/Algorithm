package practice.sort;

import practice.utils.Utils;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.5.
 */
public class HeapSort {

  public static void main(String[] args) {
    int[] arr = Utils.createIntArr(10, 10);
//    System.out.println(Arrays.toString(practice.arr));
//    heapSort(practice.arr);
//    System.out.println(Arrays.toString(practice.arr));
    System.out.println(check(arr));
  }

  private static boolean check(int[] arr) {
    int[] arr1 = Utils.copyIntArr(arr);
    int[] arr2 = Utils.copyIntArr(arr);
    Arrays.sort(arr1);
    heapSort(arr2);
    return Utils.arrEquals(arr1, arr2);
  }

  private static void heapSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      heapInsert(arr, i);
    }
    int heapSize = arr.length;
    while (heapSize > 0) {
      Utils.swap(arr, 0, heapSize - 1);
      heapify(arr, 0, --heapSize);
    }
  }

  private static void heapInsert(int[] arr, int index) {
    while (arr[(index - 1) / 2] < arr[index]) {
      Utils.swap(arr, index, (index - 1) / 2);
      index = (index - 1) / 2;
    }
  }

  private static void heapify(int[] arr, int index, int heapSize) {
    int left = index * 2 + 1;
    while (left < heapSize) {
      int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ?
        left + 1 : left;
      largest = arr[largest] > arr[index] ? largest : index;
      if (largest == index) {
        break;
      }
      Utils.swap(arr, largest, index);
      index = largest;
      left = index * 2 + 1;
    }
  }
}
