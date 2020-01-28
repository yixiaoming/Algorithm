package practice.sort;

import practice.utils.Utils;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.4.
 */
public class InsertSort {

  public static void main(String[] args) {

    int[] arr = Utils.createIntArr(100, 100);

    System.out.println(Arrays.toString(arr));
    check(arr);

  }

  private static void insertSort(int[] arr){
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          Utils.swap(arr, j, j-1);
        }
      }
    }
  }

  private static void rightMethod(int[] arr){
    Arrays.sort(arr);
  }

  private static void check(int[] arr){
    int[] arr2 = Arrays.copyOf(arr, arr.length);
    int[] arr3 = Arrays.copyOf(arr, arr.length);

    insertSort(arr2);
    System.out.println(Arrays.asList(arr2));
    rightMethod(arr3);
    if(!Utils.arrEquals(arr2, arr3)){
      System.out.println("error");
    }else{
      System.out.println("right");
    }
  }
}
