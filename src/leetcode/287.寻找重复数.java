/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int pre = 0;
        while (slow != pre) {
            pre = nums[pre];
            slow = nums[slow];
        }
        return pre;
    }
}
// @lc code=end
