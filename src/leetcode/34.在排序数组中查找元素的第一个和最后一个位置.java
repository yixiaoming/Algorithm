package leetcode;/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == target) {
                start = i;
                break;
            }
            i++;
        }
        while (i < nums.length && nums[i] == target) {
            end = i;
            i++;
        }
        return new int[]{start, end};
    }
}
// @lc code=end

