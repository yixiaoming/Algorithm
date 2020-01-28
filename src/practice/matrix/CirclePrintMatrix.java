package practice.matrix;

/**
 * Created by Administrator on 19.10.10.
 * <p>
 * 循环按圈打印矩阵
 * <p>
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * <p>
 * 打印结果：
 * 1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12
 */
public class CirclePrintMatrix {

  public static void main(String[] args) {
    int[][] matrix = new int[4][3];
    int count = 1;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = count++;
      }
    }

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.printf("%2d,", matrix[i][j]);
      }
      System.out.println();
    }

    printMatrix(matrix);
  }

  public static void printMatrix(int[][] matrix) {
    int ar = 0;
    int ac = 0;
    int br = matrix.length - 1;
    int bc = matrix[0].length - 1;

    while (ar <= br || ac <= bc) {
      printByPoint(matrix, ar, ac, br, bc);
      ar++;
      br--;
      ac++;
      bc--;
    }
  }

  public static void printByPoint(int[][] matrix, int ar, int ac, int br, int bc) {
    if (ar == br && ac == bc) {
      System.out.printf(matrix[ac][ar] + ",");
    } else if (ar == br) {
      while (ac <= bc) {
        System.out.printf(matrix[ar][ac++] + ",");
      }
    } else if (ac == bc) {
      while (ar <= br) {
        System.out.printf(matrix[ar++][ac] + ",");
      }
    } else {
      int temp = ac;
      while (temp <= bc - 1) {
        System.out.printf(matrix[ar][temp++] + ",");
      }
      temp = ar;
      while (temp <= br - 1) {
        System.out.printf(matrix[temp++][bc] + ",");
      }
      temp = bc;
      while (temp >= ac + 1) {
        System.out.printf(matrix[br][temp--] + ",");
      }
      temp = br;
      while (temp >= ar + 1) {
        System.out.printf(matrix[temp--][ac] + ",");
      }
    }
  }
}
