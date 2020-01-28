package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int left = 0;
                int right = 0;
                left = j == 0 ? 0 : result.get(j-1);
                right = j == i ? 0 : result.get(j);
                temp.add( left + right );
            }
            result = temp;
        }
        return result;
    }
}
// @lc code=end

