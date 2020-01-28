package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer majorNum = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majorNum = nums[i];
            }
            count = majorNum == nums[i] ? count + 1 : count - 1;
        }
        
        return majorNum;
    }

    public int hash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCountNum = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = map.get(nums[i]) == null ? 0 : map.get(nums[i]) + 1;
            map.put(nums[i], count);
            if (count > maxCount) {
                maxCount = count;
                maxCountNum = nums[i];
            }
        }
        return maxCountNum;
    }

}
// @lc code=end
