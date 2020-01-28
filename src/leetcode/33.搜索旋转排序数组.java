package leetcode;/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int i;
        if (nums[0] > target) {
            i = nums.length - 1;
            while (i >= 0 && nums[i] >= target) {
                if(nums[i] == target) return i;
                i--;
            }
        } else if (nums[0] < target) {
            i = 0;
            while (i <= nums.length-1 && nums[i] <= target) {
                if(nums[i] == target) return i;
                i++;
            }
        } else {
            return 0;
        }
        return -1;
    }
}
// @lc code=end

