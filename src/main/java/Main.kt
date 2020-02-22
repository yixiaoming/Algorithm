import javax.swing.LookAndFeel

class Solution1 {
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            var mid = left + (right - left) / 2
            when {
                nums[mid] == target -> {
                    return true
                }
                nums[mid] < target -> {
                    if (target > nums[right]) {
                        var flag = false
                        while (right - 1 >= 0 && nums[right - 1] <= nums[right]) {
                            right--
                            flag = true
                        }
                        if (!flag) right--
                    } else {
                        left = mid + 1
                    }
                }
                else -> {
                    if (target < nums[left]) {
                        var flag = false
                        while (left + 1 < nums.size && nums[left + 1] >= nums[left]) {
                            left++
                            flag = true
                        }
                        if (!flag) left++
                    } else {
                        right = mid - 1
                    }
                }
            }
        }
        return false
    }
}

fun main() {
    val solution = Solution1()
    val arr = intArrayOf(1, 1, 3, 1)
    println(solution.search(arr, 3))
}