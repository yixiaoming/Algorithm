/*
 * @lc app=leetcode.cn id=23 lang=kotlin
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        var sortedList = ListNode(0)
        var p = sortedList
        while (true){
            var minIndex = -1
            var minNode = ListNode(Int.MAX_VALUE)
            for ((index, head) in lists.withIndex()) {
                if (head != null) {
                    if (head.`val` < minNode.`val`) {
                        minNode = head
                        minIndex = index
                    }
                }
            }
            if (minIndex == -1) break

            var temp = lists[minIndex]
            lists[minIndex] = lists[minIndex]?.next
            temp?.next = null

            p.next = temp
            p = p.next!!
        }
        return sortedList.next
    }
}
// @lc code=end

