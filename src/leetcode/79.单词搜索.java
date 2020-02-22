/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {

    int[][] directions = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    boolean[][] marks;

    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        marks = new boolean[rows][cols];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean inArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean dfs(char[][] board, int row, int col, String findStr, int index) {
        if (index == findStr.length() - 1) return board[row][col] == findStr.charAt(index);
        if (board[row][col] == findStr.charAt(index)) {
            marks[row][col] = true;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (inArea(newRow, newCol) && !marks[newRow][newCol]) {
                    if(dfs(board, newRow, newCol, findStr, index + 1)){
                        return true;
                    }
                }
            }
            marks[row][col] = false;
        }
        return false;
    }
}
// @lc code=end

