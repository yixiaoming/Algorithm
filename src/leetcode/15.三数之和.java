package leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            // 当前值等于前一个值，跳过
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 排除掉连续的数
                    while (R - 1 > L && nums[R - 1] == nums[R])
                        R--;
                    while (L + 1 < R && nums[L + 1] == nums[L])
                        L++;
                    L++;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return results;
    }
}
// @lc code=end
