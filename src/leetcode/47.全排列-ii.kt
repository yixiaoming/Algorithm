/*
 * @lc app=leetcode.cn id=47 lang=kotlin
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        var results = mutableListOf<List<Int>>()
        nums.sort()
        fun backtrack(index: Int, nums: IntArray) {
            if (index == nums.size - 1) {
                results.add((nums.toList() as List<Int>))
                return
            }
            var last = mutableSetOf<Int>()
            for (i in index until nums.size) {
                if (last.contains(nums[i])){
                    continue
                }
                last.add(nums[i])
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

