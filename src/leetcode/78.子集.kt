/*
 * @lc app=leetcode.cn id=78 lang=kotlin
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    // fun subsets(nums: IntArray): List<List<Int>> {
    //     var result = mutableListOf<MutableList<Int>>()
    //     fun backtrack(index: Int, tempList: MutableList<Int>) {
    //         result.add(tempList)
    //         for (i in index until nums.size) {
    //             var newList = ArrayList<Int>(tempList)
    //             newList.add(nums[i])
    //             backtrack(i + 1, newList)
    //         }
    //     }
    //     backtrack(0, mutableListOf())
    //     return result
    // }

    fun subsets(nums: IntArray): List<List<Int>> {
        var result = ArrayList<ArrayList<Int>>().apply {
            add(ArrayList<Int>())
        }
        for (i in 0..nums.size - 1) {
            for (j in result.size - 1 downTo 0) {
                var newList = ArrayList(result.get(j))
                newList.add(nums[i])
                result.add(newList)
            }
        }
        return result
    }
}
// @lc code=end

