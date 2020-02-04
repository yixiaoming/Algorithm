/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (76.26%)
 * Likes:    139
 * Dislikes: 0
 * Total Accepted:    24.2K
 * Total Submissions: 31.6K
 * Testcase Example:  '3'
 *
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        process(1, matrix, 0, 0, n - 1, n - 1);
        return matrix;
    }

    public void process(int cur, int[][] matrix, int left, int top, int right, int down) {
        if (left > right || top > down) return;
        if (left == right && top == down) {
            matrix[left][top] = cur;
            return;
        }
        int i = top;
        int j = left;
        while (j < right) {
            matrix[i][j++] = cur++;
        }
        while (i < down) {
            matrix[i++][j] = cur++;
        }
        while (j > left) {
            matrix[i][j--] = cur++;
        }
        while (i > top) {
            matrix[i--][j] = cur++;
        }
        process(cur, matrix, left + 1, top + 1, right - 1, down - 1);
    }
}
// @lc code=end

