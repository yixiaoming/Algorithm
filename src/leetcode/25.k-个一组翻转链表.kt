/*
 * @lc app=leetcode.cn id=25 lang=kotlin
 *
 * [25] K 个一组翻转链表
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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var p = head
        for (i in 1..k) {
            if (p == null) return head
            p = p.next
        }
        var newHead = reverseKGroup(p, k)

        var temp = reverseList(head, p)
        p = temp
        while (p?.next != null) p = p.next
        p!!.next = newHead
        return temp
    }

    fun reverseList(head: ListNode?, tail: ListNode?): ListNode? {
        if (head?.next == null) return head
        var pre: ListNode? = null
        var cur = head
        var next = cur.next
        while (cur != tail) {
            cur!!.next = pre
            pre = cur
            cur = next
            if (next != null) {
                next = next!!.next
            }
        }
        return pre
    }
}
// @lc code=end

