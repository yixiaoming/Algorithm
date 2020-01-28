package practice.unionFindSet;

/**
 * Created by Administrator on 19.10.19.
 * <p>
 * 一个矩阵中上下左右所有相连的1构成一个岛
 * <p>
 * 求一个矩阵中有多少个岛
 * <p>
 * 1 1 1 0 0 0 1
 * 0 0 1 0 0 0 1
 * 1 0 0 0 0 0 0
 * 0 1 1 0 0 0 0
 * 1 1 0 0 0 0 0
 * 例子中有4个岛
 * <p>
 * 解法一：递归
 * 解法二：考虑并行合并的话，使用并查集，将大矩阵分成小矩阵，然后根据小矩阵边相连合并
 */
public class MatrixIsland {

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 1, 1, 0, 0, 0, 1},
      {0, 1, 1, 0, 0, 0, 1},
      {1, 1, 0, 0, 0, 0, 0},
      {0, 1, 1, 0, 0, 0, 0},
      {1, 1, 0, 0, 0, 0, 0}
    };

    System.out.println(calculateIsland(matrix));
  }

  private static int calculateIsland(int[][] matrix) {
    int row = matrix.length - 1;
    int col = matrix[0].length - 1;
    int count = 0;
    for (int i = 0; i <= row; i++) {
      for (int j = 0; j <= col; j++) {
        if (matrix[i][j] == 1) {
          count++;
          infect(matrix, i, j, row, col);
        }
      }
    }
    return count;
  }

  private static void infect(int[][] matrix, int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i > row || j > col || matrix[i][j] != 1) {
      return;
    }
    matrix[i][j] = 2;
    infect(matrix, i - 1, j, row, col);
    infect(matrix, i, j - 1, row, col);
    infect(matrix, i + 1, j, row, col);
    infect(matrix, i, j + 1, row, col);
  }
}
