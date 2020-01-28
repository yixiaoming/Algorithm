package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return results;
        Arrays.sort(nums);
        int L = 0;
        int len = nums.length;
        while (L < nums.length - 3) {
            if (nums[L] * 4 > target) {
                break;
            }
            while (L > 0 && nums[L] == nums[L - 1])
                L++;
            int R = nums.length - 1;
            while (R - L >= 3) {
                if (nums[R] * 4 < target) {
                    break;
                }
                while (R < len-1 && nums[R] == nums[R + 1])
                    R--;
                int i = L + 1;
                int j = R - 1;
                while (i < j) {
                    int sum = nums[L] + nums[i] + nums[j] + nums[R];
                    if (sum == target) {
                        results.add(Arrays.asList(nums[L], nums[i], nums[j], nums[R]));
                        i++;
                        while (i < R && nums[i] == nums[i - 1])
                            i++;
                        j--;
                        while (j > L && nums[j] == nums[j + 1])
                            j--;
                    } else if (sum < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
                R--;
            }
            L++;
        }
        return results;
    }
}
// @lc code=end
