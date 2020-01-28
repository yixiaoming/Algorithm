package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        result.add(row1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int left = 0;
                int right = 0;
                right = j == i ? 0 : result.get(i - 1).get(j);
                left = j == 0 ? 0 : result.get(i - 1).get(j - 1);
                rowList.add(left + right);
            }
            result.add(rowList);
        }

        return result;
    }
}
// @lc code=end
