package leetcode;/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            Arrays.sort(nums);
        } else {
            int minIndex = i + 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex] && nums[j] > nums[i]) minIndex = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
            Arrays.sort(nums, i + 1, nums.length);
        }
    }
}
// @lc code=end

