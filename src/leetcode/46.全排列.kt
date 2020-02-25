/*
 * @lc app=leetcode.cn id=46 lang=kotlin
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        var results = mutableListOf<List<Int>>()

        fun backtrack(index: Int, nums: IntArray) {
            if (index == nums.size - 1) {
                results.add((nums.toList() as List<Int>))
                return
            }
            for (i in index until nums.size) {
                swap(index, i, nums)
                backtrack(index + 1, nums)
                swap(index, i, nums)
            }
        }
        backtrack(0, nums)
        return results
    }

    fun swap(i: Int, j: Int, nums: IntArray) {
        var temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}
// @lc code=end

