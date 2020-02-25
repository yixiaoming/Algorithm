class Solution1 {
    fun permute(nums: IntArray): List<List<Int>> {
        var results = mutableListOf<List<Int>>()
        fun backtrack(index: Int, nums: IntArray) {
            if (index == nums.size - 1) {
                results.add((nums.toList() as List<Int>))
                return
            }
            for (i in index until nums.size) {
                var flag = false
                for (j in i - 1 downTo index) {
                    if (nums[j] == nums[i]) {
                        flag = true
                        break
                    }
                }
                if (flag) continue
                swap(index, i, nums)
                backtrack(index + 1, nums)
                swap(index, i, nums)
            }
        }
        backtrack(0, nums)
        return results
    }
}

fun swap(i: Int, j: Int, nums: IntArray) {
    var temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

fun main() {
    val solution = Solution1()
    val arr = intArrayOf(0, 0, 0, 1, 2)
    println(solution.permute(arr))
}