/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {

    int[][] direction = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 },
            { 0, -1 } };

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] next = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                process(board, next, row, col, i, j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = next[i][j];
            }
        }
    }

    public void process(int[][] board, int[][] next, int row, int col, int i, int j) {
        int liveSroundCount = 0;
        for (int[] direct : direction) {
            int tempi = i;
            int tempj = j;
            tempi += direct[0];
            tempj += direct[1];
            if (tempi >= 0 && tempi < row && tempj >= 0 && tempj < col) {
                if (board[tempi][tempj] == 1)
                    liveSroundCount++;
            }
        }
        if (board[i][j] == 1) {
            if (liveSroundCount >= 2 && liveSroundCount <= 3) {
                next[i][j] = 1;
            } else {
                next[i][j] = 0;
            }
        } else {
            if (liveSroundCount == 3) {
                next[i][j] = 1;
            }
        }
    }
}
// @lc code=end
