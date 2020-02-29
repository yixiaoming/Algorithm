/*
 * @lc app=leetcode.cn id=52 lang=kotlin
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    fun totalNQueens(n: Int): Int {
        var result = 0
        var matrix = ArrayList<ArrayList<String>>(n).apply {
            for (i in 1..n) {
                var list = ArrayList<String>(n).apply {
                    for (j in 1..n) {
                        this.add(".")
                    }
                }
                this.add(list)
            }
        }

        fun canPlace(row: Int, col: Int): Boolean {
            for (j in 0 until n) {
                if (matrix[row][j] == "Q") return false
            }
            for (i in 0 until n) {
                if (matrix[i][col] == "Q") return false
            }
            var i = row
            var j = col
            while (i >= 0 && j >= 0) {
                if (matrix[i--][j--] == "Q") return false
            }
            i = row
            j = col
            while (i < n && j < n) {
                if (matrix[i++][j++] == "Q") return false
            }
            i = row
            j = col
            while (i >= 0 && j < n) {
                if (matrix[i--][j++] == "Q") return false
            }
            i = row
            j = col
            while (i < n && j >= 0) {
                if (matrix[i++][j--] == "Q") return false
            }
            return true
        }

        fun backtrack(curRow: Int) {
            for (i in 0 until n) {
                if (canPlace(curRow, i)) {
                    matrix[curRow][i] = "Q"
                    if (curRow == n - 1) {
                        result++
                    } else {
                        backtrack(curRow + 1)
                    }
                    matrix[curRow][i] = "."
                }
            }
        }
        backtrack(0)
        return result
    }
}
// @lc code=end

