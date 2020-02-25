/*
 * @lc app=leetcode.cn id=90 lang=kotlin
 *
 * [90] 子集 II
 */

// @lc code=start
import java.util.*
class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        var results = mutableListOf<MutableList<Int>>()
        fun backtrack(index: Int, templist: MutableList<Int>) {
            results.add(templist)
            var i = index
            while (i < nums.size) {
                if (i > index && nums[i] == nums[i - 1]) {
                    i++
                    continue
                }
                var newlist = ArrayList<Int>(templist)
                newlist.add(nums[i])
                backtrack(i + 1, newlist)
                i++
            }
        }
        backtrack(0, mutableListOf())
        return results
    }
}
// @lc code=end

