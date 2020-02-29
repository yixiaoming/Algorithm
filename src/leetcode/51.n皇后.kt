/*
 * @lc app=leetcode.cn id=51 lang=kotlin
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        var results = ArrayList<ArrayList<String>>()
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

        fun addSolution(matrix: ArrayList<ArrayList<String>>) {
            var copyMatrix = ArrayList<String>()
            for ((i, row) in matrix.withIndex()) {
                var copyRow = StringBuffer()
                for (col in matrix[i]) {
                    copyRow.append(col)
                }
                copyMatrix.add(copyRow.toString())
            }
            results.add(copyMatrix)
        }

        fun backtrack(curRow: Int) {
            for (i in 0 until n) {
                if (canPlace(curRow, i)) {
                    matrix[curRow][i] = "Q"
                    if (curRow == n - 1) {
                        addSolution(matrix)
                    } else {
                        backtrack(curRow + 1)
                    }
                    matrix[curRow][i] = "."
                }
            }
        }
        backtrack(0)
        return results
    }
}
// @lc code=end

