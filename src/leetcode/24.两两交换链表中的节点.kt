/*
 * @lc app=leetcode.cn id=24 lang=kotlin
 *
 * [24] 两两交换链表中的节点
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
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        var temp = swapPairs(head.next!!.next)
        var returnHead = head.next
        head.next!!.next = head
        head.next = temp
        return returnHead
    }
}
// @lc code=end

