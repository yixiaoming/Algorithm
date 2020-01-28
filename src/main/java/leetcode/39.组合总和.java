package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return results;
        Arrays.sort(candidates);
        process(target, candidates, 0, new LinkedList<>());
        return results;
    }

    void process(int target, int[] candidates, int index, LinkedList<Integer> result) {
        if (target < 0) return;
        if (target == 0) {
            results.add(new LinkedList<>(result));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            result.add(candidates[i]);
            process(target - candidates[i], candidates, i, result);
            result.removeLast();
        }
    }
}
// @lc code=end
