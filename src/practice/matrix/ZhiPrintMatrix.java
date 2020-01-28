package practice.matrix;

/**
 * Created by Administrator on 19.10.10.
 * <p>
 * 之字形打印矩阵
 * <p>
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * <p>
 * 打印结果：
 * 1 2 6 11 7 3 4 8 12 16 17 13 9 5 10 14 18 19 15 20
 */
public class ZhiPrintMatrix {

  public static void main(String[] args) {
    int[][] matrix = new int[4][5];
    int count = 1;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        matrix[i][j] = count++;
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.printf("%2d,", matrix[i][j]);
      }
      System.out.println();
    }


    int[] a = {0, 0};
    int[] b = {0, 0};
    boolean flag = false;
    while (!(a[0] > matrix.length - 1 && a[1] >= matrix[0].length - 1)) {
      zhiprint(matrix, a[0], a[1], b[0], b[1], flag);
      flag = !flag;
      if (a[1] != matrix[0].length - 1) {
        a[1]++;
      } else {
        a[0]++;
      }

      if (b[0] != matrix.length - 1) {
        b[0]++;
      } else {
        b[1]++;
      }
    }
  }

  public static void zhiprint(int[][] matrix, int a, int b, int c, int d, boolean flag) {
    while (a <= c || b >= d) {
      if (flag) {
        System.out.printf("%3d", matrix[a][b]);
        b--;
        a++;
      } else {
        System.out.printf("%3d", matrix[c][d]);
        c--;
        d++;
      }
    }
  }
}
