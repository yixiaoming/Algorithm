package practice.matrix;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.10.
 * <p>
 * 在横向和纵向都排好序的矩阵中找某个数，找到返回矩阵绘制，没有找到返回-1
 */
public class FindInSortedMatrix {

  public static void main(String[] args) {
    int[][] arr = new int[5][6];
    int index = 1;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 6; j++) {
        arr[i][j] = index++;
      }
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 6; j++) {
        System.out.printf("%3d", arr[i][j]);
      }
      System.out.println();
    }
    System.out.println();
    System.out.println(Arrays.toString(findInMatrix(arr, 10)));
    System.out.println(Arrays.toString(findInMatrix(arr, 31)));
    System.out.println(Arrays.toString(findInMatrix(arr, 1)));
    System.out.println(Arrays.toString(findInMatrix(arr, 30)));
    System.out.println(Arrays.toString(findInMatrix(arr, 20)));
  }

  public static int[] findInMatrix(int[][] arr, int value) {
    if (arr == null || arr.length == 0) {
      return new int[]{-1};
    }
    int row = 0;
    int col = arr[row].length - 1;
    while (col >= 0 && row < arr.length) {
      if (arr[row][col] > value) {
        col--;
      } else if (arr[row][col] < value) {
        row++;
      } else {
        return new int[]{row, col};
      }
    }
    return new int[]{-1};
  }
}
