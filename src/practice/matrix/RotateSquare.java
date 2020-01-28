package practice.matrix;

/**
 * Created by Administrator on 19.10.10.
 * <p>
 * 旋转正方形
 * <p>
 * 1  2  3  4
 * 6  7  8  9
 * 11 12 13 14
 * 16 17 18 19
 * <p>
 * 结果：
 * 16 11 6  1
 * 17 12 7  2
 * 18 13 8  3
 * 19 14 9  4
 */
public class RotateSquare {

  public static void main(String[] args) {
    int[][] matrix = new int[4][4];
    int count = 1;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        matrix[i][j] = count++;
      }
    }

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.printf("%2d,", matrix[i][j]);
      }
      System.out.println();
    }

    matrix = rotateSquare(matrix);
    System.out.println();

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.printf("%2d,", matrix[i][j]);
      }
      System.out.println();
    }
  }

  private static int[][] rotateSquare(int[][] matrix) {
    if (matrix == null) return matrix;
    int row = matrix.length;
    if (row == 0) return matrix;
    int col = matrix[0].length;
    if (col != row) return matrix;

    int a = 0;
    int b = row - 1;
    while (a <= b) {
      rotate(matrix, a, a, b, b);
      a++;
      b--;
    }
    return matrix;
  }

  private static void rotate(int[][] matrix, int ar, int ac, int br, int bc) {
    if (matrix == null) return;
    int row = matrix.length;
    if (row == 0) return;
    int col = matrix[0].length;
    if (col != row) return;

    int step = br - ar;
    for (int i = 0; i < step; i++) {
      int temp = matrix[ar][ac + i];
      matrix[ar][ac + i] = matrix[br - i][ac];
      matrix[br - i][ac] = matrix[br][bc - i];
      matrix[br][bc - i] = matrix[ar + i][bc];
      matrix[ar + i][bc] = temp;
    }
  }
}
