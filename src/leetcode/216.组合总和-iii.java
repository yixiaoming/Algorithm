import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {

    List<List<Integer>> results = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {
        process(k, n, 1, new ArrayList<>());
        return results;
    }

    public void process(int k, int n, int start, List<Integer> result) {
        if (k < 0 || n < 0) {
            return;
        }
        if (k == 0 && n == 0) {
            results.add(new ArrayList(result));
            return;
        }
        for (int i = start; i <= 9; i++) {
            result.add(i);
            process(k-1, n-i, i+1, result);
            result.remove(new Integer(i));
        }
    }
}
// @lc code=end
