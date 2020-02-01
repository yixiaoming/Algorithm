/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (38.30%)
 * Likes:    286
 * Dislikes: 0
 * Total Accepted:    37.6K
 * Total Submissions: 98K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix.length == 0)
            return list;
        process(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1, list);
        return list;
    }

    public void process(int[][] matrix, int left, int top, int right, int down, List<Integer> list) {
        if (left > right || top > down)
            return;
        if (left == right && top == down) {
            list.add(matrix[left][top]);
            return;
        }
        if (left == right) {
            for (int i = top; i <= down; i++) {
                list.add(matrix[i][left]);
            }
            return;
        }
        if (top == down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            return;
        }
        for (int i = left; i < right; i++)
            list.add(matrix[top][i]);
        for (int i = top; i < down; i++)
            list.add(matrix[i][right]);
        for (int i = right; i > left; i--)
            list.add(matrix[down][i]);
        for (int i = down; i > top; i--)
            list.add(matrix[i][left]);
        process(matrix, left + 1, top + 1, right - 1, down - 1, list);
    }
}
// @lc code=end
