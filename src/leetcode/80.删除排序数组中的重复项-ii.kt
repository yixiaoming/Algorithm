/*
 * @lc app=leetcode.cn id=80 lang=kotlin
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if(nums.size < 3) return nums.size
        var left = 0
        var right = 0
        var cur = nums[0]
        while (right < nums.size) {
            var count = 0
            while (right + count < nums.size && nums[right + count] == cur) {
                count++
            }
            if (count >= 2) {
                nums[left++] = nums[right]
                nums[left++] = nums[right]
            } else {
                nums[left++] = nums[right]
            }
            right += count
            if (right >= nums.size) break
            cur = nums[right]
        }
        return left
    }
}
// @lc code=end

